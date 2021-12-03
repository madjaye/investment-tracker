package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import com.madjaye.investmenttracker.investment.domain.Category;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "category")
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
class CategoryJpaEntity extends ManuallyIdentifiedEntity<CategoryId> {

    @EmbeddedId
    private CategoryId id;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private static CategoryJpaEntity from(CategoryId categoryId) {
        return new CategoryJpaEntity(categoryId, null, null);
    }

    public static CategoryJpaEntity from(Category category) {
        return from(new CategoryId(category.name(), category.userId(), true));
    }

    @Override
    public CategoryId getId() {
        return id;
    }

    public String getName() {
        return id.getName();
    }

    public Long getUserId() {
        return id.getUserId();
    }
}
