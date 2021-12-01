package com.madjaye.investmenttracker.investment.application.service;

import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryCommand;
import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryUseCase;
import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import com.madjaye.investmenttracker.investment.domain.Category;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public record AddCategoryService(SaveCategoryPort saveCategoryPort) implements AddCategoryUseCase {

    @Override
    public void addCategory(AddCategoryCommand addCategoryCommand) {
        var category = new Category(addCategoryCommand.name(), addCategoryCommand.userId());
        try {
            saveCategoryPort.saveCategory(category);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(category);
        }
    }
}
