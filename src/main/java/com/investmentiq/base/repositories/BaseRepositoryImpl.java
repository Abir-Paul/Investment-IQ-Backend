package com.investmentiq.base.repositories;

import com.investmentiq.base.entities.BaseEntity;
import com.investmentiq.base.globalEnums.GlobalEnums;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Objects;
import java.util.Optional;

public class BaseRepositoryImpl<T extends BaseEntity, ID> extends SimpleJpaRepository<T, ID>
        implements BaseRepository<T, ID> {

    private final EntityManager em;

    public BaseRepositoryImpl(
            JpaEntityInformation<T, ID> info,
            EntityManager em) {
        super(info, em);
        this.em = em;
    }

    @Override
    public Optional<T> findActiveById(ID id) {
        T entity = em.find(getDomainClass(), id);
        return (Objects.isNull(entity))
                ? Optional.empty()
                : (entity.getDelFlg() != GlobalEnums.delFlg.N) ? Optional.empty() : Optional.of(entity);
    }

//    @Override
//    @Transactional
//    public void softDelete(ID id) {
//        T entity = em.find(getDomainClass(), id);
//        if (entity != null) {
//            entity.setDelFlg(GlobalEnums.delFlg.Y);
//            em.merge(entity);
//        }
//    }
}

