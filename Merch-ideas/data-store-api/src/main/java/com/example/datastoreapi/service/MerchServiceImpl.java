package com.example.datastoreapi.service;

import com.example.datastoreapi.entity.MerchEntity;
import com.example.datastoreapi.entity.MerchRepository;
import com.example.datastoreapi.model.MerchRequest;
import com.example.datastoreapi.model.MerchResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MerchServiceImpl implements MerchService {

    @Autowired
    MerchRepository merchRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public MerchResponse createMerch(MerchRequest merchRequest) {
        merchRequest.setMerchId(UUID.randomUUID().toString());
        MerchEntity merchEntity = modelMapper.map(merchRequest, MerchEntity.class);
        merchEntity = merchRepository.save(merchEntity);
        return modelMapper.map(merchEntity, MerchResponse.class);
    }

    @Override
    public MerchResponse getMerchById(String merchId) {
        return modelMapper.map(merchRepository.getMerchEntityByMerchId(merchId), MerchResponse.class);
    }

    @Override
    public List<MerchResponse> getAllMerch() {
        return merchRepository.getMerchEntitiesBy().stream()
                .map(merch -> modelMapper.map(merch, MerchResponse.class)).collect(Collectors.toList());
    }

    @Override
    public MerchResponse updateMerch(MerchRequest merchRequest) {
        MerchEntity merchEntity = modelMapper.map(merchRequest, MerchEntity.class);
        MerchEntity dbEntity = merchRepository.getMerchEntityByMerchId(merchEntity.getMerchId());
        merchEntity.setId(dbEntity.getId());
        merchEntity = merchRepository.save(merchEntity);
        return modelMapper.map(merchEntity, MerchResponse.class);
    }

    @Override
    public void deleteMerchById(String merchId) {
        merchRepository.deleteMerchEntityByMerchId(merchId);
    }
}
