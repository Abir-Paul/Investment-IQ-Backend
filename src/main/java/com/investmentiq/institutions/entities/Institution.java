package com.investmentiq.institutions.entities;

import com.investmentiq.base.entities.BaseEntity;
import com.investmentiq.address.entities.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity(name = "financial_institutions")
public class Institution extends BaseEntity {

    @NotBlank(message = "The name cannot be blank")
    @Column(length = 30, nullable = false)
    private String businessName;

    @NotBlank(message = "type is expected")
    @Column(length = 11, nullable = false)
    private String type;

    @Getter
    @Transient
    private List<Address> addressList;

    @Override
    public void entitySpecificPrePersist() {

        setBusinessName(getBusinessName().trim());

        setType(getType().trim());

    }

}
