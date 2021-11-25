package com.madjaye.investmenttracker.investment.adapter.out;

import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import com.madjaye.investmenttracker.investment.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements SaveCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        var categoryJpaEntity = CategoryJpaEntity.from(category);
        categoryRepository.save(categoryJpaEntity);
    }
}
