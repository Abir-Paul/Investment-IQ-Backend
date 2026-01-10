package com.investmentiq.institutions.services.impl;

import com.investmentiq.institutions.entities.Institution;
import com.investmentiq.institutions.repositories.InstitutionRepo;
import com.investmentiq.institutions.services.InstitutionService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;
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
        Institution dbInstitution=null;
        if(Objects.nonNull(institution.getId()))
        {
            dbInstitution=institutionRepo.findActiveById(institution.getId()).orElseThrow(()->new RuntimeException("Entity Does Not Exist"));
            dbInstitution.setBusinessName(institution.getBusinessName());
            dbInstitution.setType(institution.getType());
        }
        institutionRepo.save(Objects.nonNull(dbInstitution)?dbInstitution:institution);
    }

    public void checkIfInstitutionExistsById(UUID uuid)
    {
        if(institutionRepo.findActiveById(uuid).isPresent())
        {
            //throw exception
        }
    }

    public List<Institution> getAllInstitutions()
    {
        return institutionRepo.findAll();
    }
}
