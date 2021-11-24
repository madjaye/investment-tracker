package com.madjaye.investmenttracker.investment.adapter.out;

import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements SaveCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public void saveCategory(String category, Long userId) {
        var categoryEntity = new CategoryJpaEntity(new CategoryId(category, userId), null, null, true);
        categoryRepository.save(categoryEntity);
    }
}
