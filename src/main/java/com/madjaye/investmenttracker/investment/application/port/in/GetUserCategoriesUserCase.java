package com.madjaye.investmenttracker.investment.application.port.in;

import java.util.Set;

public interface GetUserCategoriesUserCase {

    Set<String> getCategories(Long userId);

}
