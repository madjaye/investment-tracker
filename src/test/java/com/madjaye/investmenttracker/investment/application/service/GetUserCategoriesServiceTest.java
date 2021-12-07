package com.madjaye.investmenttracker.investment.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.madjaye.investmenttracker.investment.application.port.out.GetCategoriesPort;
import com.madjaye.investmenttracker.investment.domain.CategoryFactory;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetUserCategoriesServiceTest {

    @Mock
    private GetCategoriesPort getCategoriesPort;

    @InjectMocks
    private GetUserCategoriesService getUserCategoriesService;

    @Test
    void shouldGetUserCategories() {
        // Given
        var userId = 1L;
        var userCategory1 = CategoryFactory.createForUserId(userId);
        var expectedCategory1 = userCategory1.name();
        var expectedCategory2 = "category 2";
        var userCategory2 = CategoryFactory.createForNameAndUserId(expectedCategory2, userId);
        var userCategories = List.of(userCategory1, userCategory2);
        given(getCategoriesPort.getAllActiveCategoriesForUser(userId)).willReturn(userCategories);

        // When
        var actualCategories = getUserCategoriesService.getCategories(userId);

        // Then
        assertThat(actualCategories).isEqualTo(Set.of(expectedCategory1, expectedCategory2));

    }

}