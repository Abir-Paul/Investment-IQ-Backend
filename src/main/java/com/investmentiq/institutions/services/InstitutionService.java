package com.investmentiq.institutions.services;

import com.investmentiq.institutions.entities.Institution;

import java.util.UUID;

public interface InstitutionService {

    void processCreateInstitution(Institution institution);

    void checkIfInstitutionExistsById(UUID uuid);
}
