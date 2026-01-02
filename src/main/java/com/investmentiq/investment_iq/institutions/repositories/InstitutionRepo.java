package com.investmentiq.investment_iq.institutions.repositories;

import com.investmentiq.base.repositories.BaseRepository;
import com.investmentiq.investment_iq.institutions.entities.Institution;

import java.util.UUID;

public interface InstitutionRepo extends BaseRepository<Institution, UUID> {
}
