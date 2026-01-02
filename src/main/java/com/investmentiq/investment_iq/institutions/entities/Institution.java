package com.investmentiq.investment_iq.institutions.entities;

import com.investmentiq.investment_iq.base.entities.BaseEntity;
import com.investmentiq.investment_iq.address.entities.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Entity(name = "financial_institutions")
public class Institution extends BaseEntity {

    @NotBlank(message = "The name cannot be blank")
    @Column(length = 30, nullable = false)
    private String businessName;

    @NotBlank(message = "type is expected")
    @Column(length = 11, nullable = false)
    private String type;

    @NotBlank(message = "displayType is expected")
    @Column(length = 20)
    private String displayType;

    @Getter
    @Transient
    private List<Address> addressList;

}
