package com.investmentiq.investment_iq.institutions.services;

import com.investmentiq.investment_iq.institutions.entities.Institution;

import java.util.UUID;

public interface InstitutionService {

    void processCreateInstitution(Institution institution);

    void checkIfInstitutionExistsById(UUID uuid);
}
