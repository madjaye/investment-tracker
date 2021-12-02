package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import static java.util.stream.Collectors.toList;

import com.madjaye.investmenttracker.investment.application.port.out.GetCategoriesPort;
import com.madjaye.investmenttracker.investment.application.port.out.SaveCategoryPort;
import com.madjaye.investmenttracker.investment.domain.Category;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements SaveCategoryPort, GetCategoriesPort {

    private final CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        var categoryJpaEntity = CategoryJpaEntity.from(category);
        categoryRepository.save(categoryJpaEntity);
    }

    @Override
    public List<Category> getAllCategories() {
        var categoryJpaEntities = categoryRepository.findAll();
        return categoryJpaEntities.stream().map(this::toCategory).collect(toList());
    }

    private Category toCategory(CategoryJpaEntity categoryJpaEntity) {
        return new Category(categoryJpaEntity.getName(), categoryJpaEntity.getUserId());
    }
}
