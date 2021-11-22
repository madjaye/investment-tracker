package com.madjaye.investmenttracker.investment.adapter.out;

import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import org.springframework.stereotype.Component;

@Component
public class CategoryPersistenceAdapter implements SaveCategoryPort {
    @Override
    public void saveCategory(String category) {

    }
}
