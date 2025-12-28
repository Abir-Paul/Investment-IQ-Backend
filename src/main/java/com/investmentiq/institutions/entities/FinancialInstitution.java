package com.investmentiq.institutions.entities;

import com.investmentiq.base.entities.BaseEntity;
import com.investmentiq.base.enums.GlobalEnums;
import com.investmentiq.base.utilities.StringHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "financial_institutions")
public class FinancialInstitution extends BaseEntity {

    @NotBlank
    @Column(length = 30, nullable = false)
    private String businessName;

    @Enumerated(EnumType.STRING)
    @Column(length=20,nullable = false)
    private GlobalEnums.InstitutionType type;

    @NotBlank
    @Column(length = 11, nullable = false)
    private String displayType;

    @Override
    public void onPrePersist() {
        if (StringHelper.hasNoContent(displayType)) {
            this.setDisplayType(this.getType().getDisplayName());
        }
    }

    @Override
    public void onPreUpdate() {
        if (StringHelper.hasNoContent(displayType)) {
            this.setDisplayType(this.getType().getDisplayName());
        }
    }


}
