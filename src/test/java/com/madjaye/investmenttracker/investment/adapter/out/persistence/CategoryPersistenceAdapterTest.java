package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.madjaye.investmenttracker.investment.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@ActiveProfiles("test")
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({CategoryPersistenceAdapter.class})
class CategoryPersistenceAdapterTest {

    @Autowired
    private CategoryPersistenceAdapter categoryPersistenceAdapter;

    @Autowired
    private CategoryRepository categoryRepository;

    @Container
    private final PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>("postgres:14.0");

    @Test
    void shouldSaveCategoryWhenNew() {
        // Given
        assertThat(postgresqlContainer.isRunning()).isTrue();
        var category = new Category("My new category", 1L);

        // When
        categoryPersistenceAdapter.saveCategory(category);

        // Then
        assertThat(categoryRepository.count()).isEqualTo(1);

    }

    @Test
    void shouldNotPersistDuplicateCategoryPerUser() {
        // Given
        var duplicateCategory = new Category("My new category", 1L);
        categoryRepository.saveAndFlush(CategoryJpaEntity.from(duplicateCategory));

        // When / Then
        assertThatThrownBy(() -> categoryPersistenceAdapter.saveCategory(duplicateCategory))
            .isInstanceOf(DataIntegrityViolationException.class);
        assertThat(categoryRepository.count()).isEqualTo(1);
    }

    @Test
    void shouldSaveCategoryIfCategoryExistsButIsDeactivated() {
        // Given
        var category = new Category("My category", 1L);
        var inactiveCategoryJpaEntity =
            new CategoryJpaEntity(new CategoryId(category.name(), category.userId(), false), null, null);
        categoryRepository.saveAndFlush(inactiveCategoryJpaEntity);

        // When
        categoryPersistenceAdapter.saveCategory(category);

        // Then
        assertThat(categoryRepository.count()).isEqualTo(2);
        assertThat(categoryRepository.findById(new CategoryId(category.name(), category.userId(), true))).isPresent();

    }

    @Test
    void shouldAllowTheSameCategoryToBeSavedByDifferentUsers() {
        // Given
        var name = "My matching category";
        var user1Category = new Category(name, 1L);
        var user2Category = new Category(name, 2L);
        categoryRepository.saveAndFlush(CategoryJpaEntity.from(user1Category));

        // When
        categoryPersistenceAdapter.saveCategory(user2Category);

        // Then
        assertThat(categoryRepository.count()).isEqualTo(2);
    }

}