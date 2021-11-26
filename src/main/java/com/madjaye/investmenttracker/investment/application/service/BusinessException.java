package com.madjaye.investmenttracker.investment.application.service;

import com.madjaye.investmenttracker.investment.domain.Category;

public class BusinessException extends RuntimeException {

    public BusinessException(Category category) {
        super(String.format("Category '%s' already exists", category.name()));
    }

}
