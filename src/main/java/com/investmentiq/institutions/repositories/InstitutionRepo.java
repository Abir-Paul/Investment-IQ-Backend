package com.investmentiq.institutions.repositories;

import com.investmentiq.base.repositories.BaseRepository;
import com.investmentiq.institutions.entities.Institution;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstitutionRepo extends BaseRepository<Institution, UUID> {
}
