package com.investmentiq.investment_iq.institutions.services.impl;

import com.investmentiq.investment_iq.institutions.entities.Institution;
import com.investmentiq.investment_iq.institutions.repositories.InstitutionRepo;
import com.investmentiq.investment_iq.institutions.services.InstitutionService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepo institutionRepo;
    private static final Logger log = LoggerFactory.getLogger(InstitutionServiceImpl.class);

    public InstitutionServiceImpl(InstitutionRepo institutionRepo) {
        this.institutionRepo = institutionRepo;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void processCreateInstitution(@Valid Institution institution)
    {
        log.info("saving institution :{}", institution);
        institutionRepo.save(institution);
    }

    public void checkIfInstitutionExistsById(UUID uuid)
    {
        if(institutionRepo.findActiveById(uuid).isPresent())
        {
            //throw exception
        }
    }
}
