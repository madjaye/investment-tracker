package com.madjaye.investmenttracker.investment.application.port.out;

import com.madjaye.investmenttracker.investment.domain.Category;

public interface SaveCategoryPort {
    void saveCategory(Category category);
}
