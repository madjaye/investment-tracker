package com.madjaye.investmenttracker.investment.adapter.out;

import com.madjaye.investmenttracker.investment.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

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
        var newCategory = new Category("My new category", 1L);

        // When
        categoryPersistenceAdapter.saveCategory(newCategory);
        categoryPersistenceAdapter.saveCategory(newCategory);

        // Then
        assertThat(categoryRepository.count()).isEqualTo(1);
    }

    @Test
    void shouldAllowTheSameCategoryToBeSavedByDifferentUsers() {
        // Given
        var name = "My new category";
        var user1Category = new Category(name, 1L);
        var user2Category = new Category(name, 2L);

        // When
        categoryPersistenceAdapter.saveCategory(user1Category);
        categoryPersistenceAdapter.saveCategory(user2Category);

        // Then
        assertThat(categoryRepository.count()).isEqualTo(2);
    }


}