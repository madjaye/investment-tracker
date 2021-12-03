package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import com.madjaye.investmenttracker.investment.domain.Category;

class CategoryJpaEntityFactory {

    static CategoryJpaEntity createInactiveForCategory(Category category) {
        return new CategoryJpaEntityBuilder()
            .withCategory(category)
            .withActive(false)
            .build();
    }

    static CategoryJpaEntity createInactiveForUserId(Long userId) {
        return new CategoryJpaEntityBuilder()
            .withActive(false)
            .withUserId(userId)
            .build();
    }

    static CategoryJpaEntity createForUserId(Long userId) {
        return new CategoryJpaEntityBuilder()
            .withUserId(userId)
            .build();
    }

    static CategoryJpaEntity createForCategoryId(CategoryId categoryId) {
        return new CategoryJpaEntityBuilder()
            .withCategoryId(categoryId)
            .build();
    }

    static CategoryJpaEntity createForCategory(Category category) {
        return new CategoryJpaEntityBuilder()
            .withCategory(category)
            .build();
    }

}
