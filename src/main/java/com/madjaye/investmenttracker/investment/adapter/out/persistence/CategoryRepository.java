package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface CategoryRepository extends JpaRepository<CategoryJpaEntity, CategoryId> {

    List<CategoryJpaEntity> findByIdActiveAndIdUserId(boolean isActive, Long userId);

}
