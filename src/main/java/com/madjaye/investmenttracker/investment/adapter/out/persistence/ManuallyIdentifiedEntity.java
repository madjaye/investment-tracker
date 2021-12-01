package com.madjaye.investmenttracker.investment.adapter.out.persistence;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
@EqualsAndHashCode
abstract class ManuallyIdentifiedEntity<I> implements Persistable<I> {

    @Transient
    private boolean isNew = true;

    @Override
    public boolean isNew() {
        return isNew;
    }

    @PrePersist
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }
}
