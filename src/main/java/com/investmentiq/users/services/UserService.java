package com.investmentiq.users.services;

import com.investmentiq.users.entities.User;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void createUser(User user);

    void updateUser(User user);

    List<User> findAllFamilyMembers();
}
