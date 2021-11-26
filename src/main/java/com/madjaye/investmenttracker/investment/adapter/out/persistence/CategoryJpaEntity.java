package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import com.madjaye.investmenttracker.investment.domain.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "category")
@ToString
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
class CategoryJpaEntity extends ManuallyIdentifiedEntity<CategoryId>{

    @EmbeddedId
    private CategoryId categoryId;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private Boolean active;

    public static CategoryJpaEntity from(Category category) {
        return new CategoryJpaEntity(new CategoryId(category.name(), category.userId()), null, null, true);
    }

    @Override
    public CategoryId getId() {
        return categoryId;
    }
}
