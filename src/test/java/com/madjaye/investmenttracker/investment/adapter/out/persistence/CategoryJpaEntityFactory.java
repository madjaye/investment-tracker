package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import com.madjaye.investmenttracker.investment.domain.Category;

class CategoryJpaEntityFactory {

    static CategoryJpaEntity createInactiveForCategory(Category category) {
        return new CategoryJpaEntityBuilder()
            .withCategory(category)
            .withActive(false)
            .build();
    }

    static CategoryJpaEntity createInactive() {
        return new CategoryJpaEntityBuilder()
            .withActive(false)
            .build();
    }

    static CategoryJpaEntity createForCategoryId(CategoryId categoryId) {
        return new CategoryJpaEntityBuilder()
            .withCategoryId(categoryId)
            .build();
    }

}
