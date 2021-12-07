package com.madjaye.investmenttracker.investment.application.service;

import com.madjaye.investmenttracker.investment.application.port.in.GetUserCategoriesUserCase;
import com.madjaye.investmenttracker.investment.application.port.out.GetCategoriesPort;
import com.madjaye.investmenttracker.investment.domain.Category;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserCategoriesService implements GetUserCategoriesUserCase {

    private final GetCategoriesPort getCategoriesPort;

    @Override
    public Set<String> getCategories(Long userId) {
        return getCategoriesPort.getAllActiveCategoriesForUser(userId).stream()
            .map(Category::name)
            .collect(Collectors.toUnmodifiableSet());
    }
}
