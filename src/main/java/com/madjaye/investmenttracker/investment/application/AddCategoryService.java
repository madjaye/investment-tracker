package com.madjaye.investmenttracker.investment.application;

import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryUseCase;
import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import org.springframework.stereotype.Service;

@Service
public record AddCategoryService(SaveCategoryPort saveCategoryPort) implements AddCategoryUseCase {

    @Override
    public void addCategory(String category) {
        saveCategoryPort.saveCategory(category);
    }
}
