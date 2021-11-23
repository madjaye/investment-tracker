package com.madjaye.investmenttracker.investment.adapter.out;

import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements SaveCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public void saveCategory(String category) {
        var categoryEntity = new CategoryJpaEntity(null, category, 1L, null, null, true);
        categoryRepository.save(categoryEntity);
    }
}
