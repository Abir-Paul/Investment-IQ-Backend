package com.investmentiq.investment_iq.address.entities;

import com.investmentiq.investment_iq.base.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
@Entity(name="address")
public class Address extends BaseEntity {

    @Column
    private String addressLine1;

    @Column
    private String addressLine2;

    @Column
    private String cityOrTown;

    @NotBlank
    @Column(nullable = false)
    private String branch;

    @NotBlank
    @Column(nullable = false)
    private String district;

    @NotBlank
    @Column(nullable = false)
    private String state;

    @NotBlank
    @Column(nullable = false)
    private String country;

    @Column
    private Integer pinCode;

    @Column(nullable = false)
    private UUID institutionId;

    @Column
    private String mapLocationUrl;

    @Override
    public void entitySpecificPrePersist()
    {
        if(Objects.isNull(getCityOrTown()))
        {
            setCityOrTown(getBranch());
        }
    }
}
