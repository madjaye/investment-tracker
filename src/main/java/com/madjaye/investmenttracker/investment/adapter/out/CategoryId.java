package com.madjaye.investmenttracker.investment.adapter.out;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class CategoryId implements Serializable {

    private String name;
    private Long userId;

}
