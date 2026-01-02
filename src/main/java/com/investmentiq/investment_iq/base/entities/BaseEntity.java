package com.investmentiq.investment_iq.base.entities;

import com.investmentiq.investment_iq.base.globalConstants.Constants;
import com.investmentiq.investment_iq.base.globalEnums.GlobalEnums;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private Instant dbLock;

    @Column(nullable = false, length = 1)
    private GlobalEnums.delFlg delFlg;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false, updatable = false)
    private String createdBy;

    @Column(nullable = false)
    private Instant updatedAt;

    @Column(nullable = false)
    private String updatedBy;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(getCreatedAt())) {
            setCreatedAt(Instant.now());
        }

        if (Objects.isNull(getUpdatedAt())) {
            setUpdatedAt(Instant.now());
        }

        if (Objects.isNull(getCreatedBy())) {
            setCreatedBy(Constants.systemCreatedEntity);
        }

        if (Objects.isNull(getUpdatedBy())) {
            setUpdatedBy(Constants.systemCreatedEntity);
        }

        setDelFlg(GlobalEnums.delFlg.N);

        entitySpecificPrePersist();

    }

    @PreUpdate
    public void preUpdate() {
        if (Objects.isNull(getUpdatedBy())) {
            setUpdatedBy(Constants.systemCreatedEntity);
        }

        if (Objects.isNull(getUpdatedAt())) {
            setUpdatedAt(Instant.now());
        }

        entitySpecificPreUpdate();

    }


    /**
     * Override in child class to implement more setters
     */
    public void entitySpecificPrePersist() {

    }

    /**
     * Override in child class to implement more setters
     */
    public void entitySpecificPreUpdate() {

    }
}
