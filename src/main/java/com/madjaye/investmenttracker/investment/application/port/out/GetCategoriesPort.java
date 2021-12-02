package com.madjaye.investmenttracker.investment.application.port.out;

import com.madjaye.investmenttracker.investment.domain.Category;
import java.util.List;

public interface GetCategoriesPort {

    List<Category> getAllCategories();

}
