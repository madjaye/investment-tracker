package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
class CategoryId implements Serializable {

    private String name;
    private Long userId;
    private Boolean active;

}
