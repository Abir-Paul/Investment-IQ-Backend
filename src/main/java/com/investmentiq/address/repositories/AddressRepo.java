package com.investmentiq.address.repositories;

import com.investmentiq.base.repositories.BaseRepository;
import com.investmentiq.address.entities.Address;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepo extends BaseRepository<Address, UUID> {
}
