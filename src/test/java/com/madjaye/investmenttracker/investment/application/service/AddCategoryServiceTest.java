package com.madjaye.investmenttracker.investment.application.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;

import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryCommand;
import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import com.madjaye.investmenttracker.investment.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

@ExtendWith(MockitoExtension.class)
class AddCategoryServiceTest {

    @Mock
    private SaveCategoryPort saveCategoryPort;

    @InjectMocks
    private AddCategoryService addCategoryService;

    @Test
    void shouldPersistCategory() {
        // Given
        var addCategoryCommand = new AddCategoryCommand("New Category", 1L);

        // When
        addCategoryService.addCategory(addCategoryCommand);

        // Then
        then(saveCategoryPort).should()
            .saveCategory(new Category(addCategoryCommand.name(), addCategoryCommand.userId()));
    }

    @Test
    void shouldThrowBusinessExceptionWhenCategoryAlreadyExists() {
        // Given
        var addCategoryCommand = new AddCategoryCommand("Duplicate Category", 1L);
        willThrow(DataIntegrityViolationException.class)
            .given(saveCategoryPort).saveCategory(new Category(addCategoryCommand.name(), addCategoryCommand.userId()));

        // When
        assertThatThrownBy(() -> addCategoryService.addCategory(addCategoryCommand))
            // Then
            .isInstanceOf(BusinessException.class)
            .hasMessage("Category '%s' already exists", addCategoryCommand.name());

    }

}