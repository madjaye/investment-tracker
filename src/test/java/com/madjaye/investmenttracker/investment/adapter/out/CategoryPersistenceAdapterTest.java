package com.madjaye.investmenttracker.investment.adapter.out;

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
        var newCategory = "My new category";

        // When
        categoryPersistenceAdapter.saveCategory(newCategory);

        // Then
        assertThat(categoryRepository.count()).isEqualTo(1);

    }

}