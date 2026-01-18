package com.investmentiq.institutions.services;

import com.investmentiq.institutions.entities.Institution;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
public interface InstitutionService {

    void processCreateInstitution(@Valid Institution institution);

    void checkIfInstitutionExistsById(UUID uuid);

    List<Institution> getAllInstitutions();
}
