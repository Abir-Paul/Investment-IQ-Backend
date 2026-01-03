package com.investmentiq.address.services;

import com.investmentiq.address.entities.Address;

import java.util.UUID;

public interface AddressService {

    void createAddressForInstitution(Address address, UUID institutionId);
}
