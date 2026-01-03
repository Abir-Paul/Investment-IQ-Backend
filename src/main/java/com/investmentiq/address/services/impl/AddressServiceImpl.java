package com.investmentiq.address.services.impl;

import com.investmentiq.address.entities.Address;
import com.investmentiq.address.repositories.AddressRepo;
import com.investmentiq.address.services.AddressService;
import com.investmentiq.institutions.services.InstitutionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final InstitutionService institutionService;

    public AddressServiceImpl(AddressRepo addressRepo, InstitutionService institutionService) {
        this.addressRepo = addressRepo;
        this.institutionService = institutionService;
    }

    @Override
    public void createAddressForInstitution(@NotNull @Valid Address addresses, @NotBlank UUID institutionId) {
        institutionService.checkIfInstitutionExistsById(institutionId);
        addressRepo.save(addresses);
    }
}
