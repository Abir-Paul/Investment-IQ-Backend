package com.investmentiq.users.services.impl;

import com.investmentiq.users.entities.User;
import com.investmentiq.users.repositories.UserRepo;
import com.investmentiq.users.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Transactional
    @Override
    public void createUser(User user) {
        setFamilyIdForNonAdmin(user);
        userRepo.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {

        Optional<User> dbUser = userRepo.findById(user.getId());

        if (dbUser.isEmpty()) {
            throw new RuntimeException("User Does Not Exist By This Id");
        }

        setFamilyIdForNonAdmin(dbUser.get());
        userRepo.save(dbUser.get());
    }

    public void setFamilyIdForNonAdmin(User user)
    {
        User currentAdminUser=getAdminUser();
        user.setFamilyId(currentAdminUser.getFamilyId());
    }

    public User getAdminUser()
    {
        return userRepo.findByPhoneNumber("9433041650");
    }

    public List<User> findAllFamilyMembers()
    {
        User currentAdminUser=getAdminUser();
        return userRepo.findByFamilyId(currentAdminUser.getFamilyId());
    }
}
