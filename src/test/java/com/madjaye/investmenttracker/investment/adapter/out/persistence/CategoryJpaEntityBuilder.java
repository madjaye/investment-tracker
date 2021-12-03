package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import com.madjaye.investmenttracker.investment.domain.Category;

class CategoryJpaEntityBuilder {

    private String name;
    private Long userId;
    private Boolean active;

    CategoryJpaEntityBuilder() {
        name = "The Category Name";
        userId = 1L;
        active = true;
    }

    CategoryJpaEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    CategoryJpaEntityBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    CategoryJpaEntityBuilder withActive(Boolean active) {
        this.active = active;
        return this;
    }

    CategoryJpaEntityBuilder withCategory(Category category) {
        this.name = category.name();
        this.userId = category.userId();
        return this;
    }

    CategoryJpaEntityBuilder withCategoryId(CategoryId categoryId) {
        this.name = categoryId.getName();
        this.userId = categoryId.getUserId();
        this.active = categoryId.getActive();
        return this;
    }

    CategoryJpaEntity build() {
        return new CategoryJpaEntity(new CategoryId(name, userId, active), null, null);
    }

}
