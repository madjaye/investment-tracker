package com.madjaye.investmenttracker.investment.adapter.in.web;

import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryCommand;
import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryUseCase;
import com.madjaye.investmenttracker.investment.application.service.BusinessException;
import com.madjaye.investmenttracker.investment.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AddCategoryController.class)
class AddCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddCategoryUseCase addCategoryUseCase;

    @Test
    void shouldReturnCreatedAfterAddingCategory() throws Exception {
        // Given
        var name = "the category";
        var userId = 1L;
        var addCategoryCommand = new AddCategoryCommand(name, userId);

        // When
        mockMvc.perform(post("/category/{category}/user/{userId}", name, userId)
            .header("Content-Type", "application/json"))

        // Then
            .andExpect(status().isCreated());
        then(addCategoryUseCase).should().addCategory(addCategoryCommand);
    }

    @Test
    void shouldReturnConflictIfBusinessExceptionThrown() throws Exception {
        // Given
        var name = "the duplicate category";
        var userId = 1L;
        var addCategoryCommand = new AddCategoryCommand(name, userId);

        // When
        willThrow(new BusinessException(new Category(name, userId)))
            .given(addCategoryUseCase).addCategory(addCategoryCommand);

        mockMvc.perform(post("/category/{category}/user/{userId}", name, userId)
            .header("Content-Type", "application/json"))

        // Then
            .andExpect(status().isConflict())
            .andExpect(response -> assertThat(response.getResolvedException() instanceof ResponseStatusException).isTrue())
            .andExpect(response -> assertThat("Category '" + name + "' already exists").isEqualTo(response.getResponse().getErrorMessage()));
    }

}