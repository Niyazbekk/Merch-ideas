package com.example.datastoreapi.service;

import com.example.datastoreapi.model.MerchRequest;
import com.example.datastoreapi.model.MerchResponse;

import java.util.List;

public interface MerchService {
    MerchResponse createMerch(MerchRequest merchRequest);

    MerchResponse getMerchById(String merchId);

    List<MerchResponse> getAllMerch();

    MerchResponse updateMerch(MerchRequest merchRequest);

    void deleteMerchById(String merchId);
}
