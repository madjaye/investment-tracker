package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import com.madjaye.investmenttracker.investment.adapter.out.persistence.CategoryId;
import com.madjaye.investmenttracker.investment.adapter.out.persistence.CategoryJpaEntity;
import com.madjaye.investmenttracker.investment.domain.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryJpaEntityTest {


    @Test
    void shouldConvertCategoryToCategoryJpaEntity() {
        // Given
        var name = "The name";
        var userId = 1L;
        var category = new Category(name, userId);
        var expectedCategoryJpaEntity = new CategoryJpaEntity(new CategoryId(name, userId), null, null, true);

        // When
        var actualCategoryJpaEnity = CategoryJpaEntity.from(category);

        // Then
        assertThat(actualCategoryJpaEnity).isEqualTo(expectedCategoryJpaEntity);

    }

}