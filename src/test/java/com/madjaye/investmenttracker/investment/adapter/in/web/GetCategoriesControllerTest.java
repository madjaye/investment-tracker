package com.madjaye.investmenttracker.investment.adapter.in.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.madjaye.investmenttracker.investment.application.port.in.GetUserCategoriesUserCase;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = GetCategoriesController.class)
class GetCategoriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GetUserCategoriesUserCase getUserCategoriesUserCase;

    @Test
    void shouldReturnListOfCategoriesForUser() throws Exception {
        // Given
        var userId = 1L;
        var categories = Set.of("cat 1", "cat 2");
        var expectedCategories = new CategoryDto(categories);
        given(getUserCategoriesUserCase.getCategories(userId)).willReturn(categories);

        // When
        var response = mockMvc.perform(get("/category/user/{userId}", userId)
            .header("Content-Type", "application/json"))

            // Then
            .andExpect(status().isOk())
            .andReturn()
            .getResponse().getContentAsString();

        assertThat(objectMapper.readValue(response, CategoryDto.class)).isEqualTo(expectedCategories);
    }

}