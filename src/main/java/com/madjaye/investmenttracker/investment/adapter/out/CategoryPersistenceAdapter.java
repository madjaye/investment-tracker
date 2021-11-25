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
        var categoryEntity = new CategoryJpaEntity(new CategoryId(category.name(), category.userId()), null, null, true);
        categoryRepository.save(categoryEntity);
    }
}
