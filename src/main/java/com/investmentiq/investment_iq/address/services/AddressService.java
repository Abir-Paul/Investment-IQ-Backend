package com.investmentiq.investment_iq.address.services;

import com.investmentiq.investment_iq.address.entities.Address;

import java.util.UUID;

public interface AddressService {

    void createAddressForInstitution(Address address, UUID institutionId);
}
