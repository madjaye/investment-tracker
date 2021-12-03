package com.madjaye.investmenttracker.investment.domain;

public class CategoryFactory {

    public static Category create() {
        return new CategoryBuilder().build();
    }

    public static Category createForUserId(Long userId) {
        return new CategoryBuilder().withUserId(userId).build();
    }
}
