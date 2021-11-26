package com.madjaye.investmenttracker.investment.adapter.in.web;

import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryCommand;
import com.madjaye.investmenttracker.investment.application.port.in.AddCategoryUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AddCategoryController.class)
class AddCategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddCategoryUseCase addCategoryUseCase;

    @Test
    void shouldAddCategory() throws Exception {
        // Given
        var name = "the category";
        var userId = 1L;
        var addCategoryCommand = new AddCategoryCommand(name, userId);

        // When
        mockMvc.perform(post("/category/{category}/user/{userId}",
            name, userId)
            .header("Content-Type", "application/json"))
            .andExpect(status().isCreated());

        // Then
        then(addCategoryUseCase).should().addCategory(addCategoryCommand);
    }

}