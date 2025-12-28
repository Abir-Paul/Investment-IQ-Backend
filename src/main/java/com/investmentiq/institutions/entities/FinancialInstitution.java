package com.investmentiq.institutions.entities;

import com.investmentiq.base.entities.BaseEntity;
import com.investmentiq.base.enums.GlobalEnums;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class FinancialInstitution extends BaseEntity {

    @NotBlank
    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private GlobalEnums.InstitutionType type;

    @NotBlank
    @Column(length = 11, nullable = false)
    private String displayName;

    @PrePersist
    public void prePersist()
    {
       if
    }


}
