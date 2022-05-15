package com.example.datastoreapi.entity;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface MerchRepository extends CrudRepository<MerchEntity, Long> {
    List<MerchEntity> getMerchEntitiesBy();

    MerchEntity getMerchEntityByMerchId(String merchId);

    @Transactional
    void deleteMerchEntityByMerchId(String merchId);
}
