package com.investmentiq.users.entities;

import com.investmentiq.base.entities.BaseEntity;
import com.investmentiq.base.utilities.StringHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "app_user")
public class User extends BaseEntity {

    @NotBlank(message = "First name is missing")
    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 30)
    private String middleName;

    @NotBlank(message="Last name is missing")
    @Column(length = 30, nullable = false)
    private String lastName;

    @NotBlank(message = "Phone number is missing")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phoneNumber;

    @NotNull(message = "Need your family details....")
    @Column(nullable = false)
    private UUID familyId;

    @Transient
    private String userName;

    private String getUserName() {
        return StringHelper.hasNoContent(getMiddleName()) ? getFirstName() + " " + getLastName() : getFirstName() + " " + getMiddleName() + " " + getLastName();
    }

    @Override
    public void entitySpecificPrePersist() {
        commonPres();
    }

    @Override
    public void entitySpecificPreUpdate() {
        commonPres();
    }

    public void commonPres() {
        setFirstName(getFirstName().trim());

        if (StringHelper.hasContent(getMiddleName())) {
            setMiddleName(getMiddleName().trim());
        }

        setLastName(getLastName().trim());
    }

}
