package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface CategoryRepository extends JpaRepository<CategoryJpaEntity, CategoryId> {

}