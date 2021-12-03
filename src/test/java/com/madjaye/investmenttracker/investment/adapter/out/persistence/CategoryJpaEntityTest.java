package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import com.madjaye.investmenttracker.investment.domain.Category;
import org.junit.jupiter.api.Test;

class CategoryJpaEntityTest {
    
    @Test
    void shouldConvertCategoryToCategoryJpaEntity() {
        // Given
        var name = "The name";
        var userId = 1L;
        var category = new Category(name, userId);
        var expectedCategoryJpaEntity =
            CategoryJpaEntityFactory.createForCategoryId(new CategoryId(name, userId, true));

        // When
        var actualCategoryJpaEntity = CategoryJpaEntity.from(category);

        // Then
        assertThat(actualCategoryJpaEntity).isEqualTo(expectedCategoryJpaEntity);

    }

}