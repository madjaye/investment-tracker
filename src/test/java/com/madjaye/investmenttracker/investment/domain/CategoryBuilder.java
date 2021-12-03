package com.madjaye.investmenttracker.investment.domain;

class CategoryBuilder {

    private String name;
    private Long userId;

    CategoryBuilder() {
        name = "The Category Name";
        userId = 1L;
    }

    CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    CategoryBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    Category build() {
        return new Category(name, userId);
    }

}