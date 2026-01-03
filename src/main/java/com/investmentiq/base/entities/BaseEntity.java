package com.investmentiq.base.entities;

import com.investmentiq.base.globalConstants.Constants;
import com.investmentiq.base.globalEnums.GlobalEnums;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private Instant dbLock;

    @Enumerated(EnumType.STRING)
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
        setId(UUID.randomUUID());

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

        setDbLock(Instant.now());

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
