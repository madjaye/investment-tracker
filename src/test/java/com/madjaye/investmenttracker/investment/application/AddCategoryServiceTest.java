package com.madjaye.investmenttracker.investment.application;

import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AddCategoryServiceTest {

    @Mock
    private SaveCategoryPort saveCategoryPort;

    @InjectMocks
    private AddCategoryService addCategoryService;

    @Test
    void shouldPersistCategory() {
        // Given
        var category = "New Category";

        // When
        addCategoryService.addCategory(category);

        // Then
        then(saveCategoryPort).should().saveCategory(category);
    }

}