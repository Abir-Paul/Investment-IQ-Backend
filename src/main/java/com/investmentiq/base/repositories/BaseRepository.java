package com.investmentiq.base.repositories;

import com.investmentiq.base.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {

    Optional<T> findActiveById(ID id);

    //void softDelete(ID id);
}

