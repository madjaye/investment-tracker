package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
class CategoryId implements Serializable {

    private String name;
    private Long userId;

}
