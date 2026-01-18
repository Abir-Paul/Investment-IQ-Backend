package com.investmentiq.users.repositories;

import com.investmentiq.base.repositories.BaseRepository;
import com.investmentiq.users.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserRepo extends BaseRepository<User, UUID> {

    //Get All Family Members By familyId
    List<User> findByFamilyId(UUID familyId);

    User findByPhoneNumber(String phoneNumber);
}
