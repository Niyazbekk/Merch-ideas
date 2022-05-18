package com.example.datastoreapi.controller;

import com.example.datastoreapi.model.MerchRequest;
import com.example.datastoreapi.model.MerchResponse;
import com.example.datastoreapi.service.MerchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merch")
public class MerchController {
    @Autowired
    MerchService merchService;

    @PostMapping
    MerchResponse createMerch(@RequestBody MerchRequest merchRequest) {
        return merchService.createMerch(merchRequest);
    }

    @GetMapping
    MerchResponse getMerchById(@RequestParam String merchId) {
        return merchService.getMerchById(merchId);
    }
    @GetMapping("/filter")
    List<MerchResponse> getMerchByCategory(@RequestParam String category){
        return merchService.getMerchByCategory(category);
    }

    @GetMapping("/all")
    List<MerchResponse> getAllMerch() {
        return merchService.getAllMerch();
    }

    @PutMapping
    MerchResponse updateMerch(@RequestParam String merchId,
                              @RequestBody MerchRequest merchRequest) {
        merchRequest.setMerchId(merchId);
        return merchService.updateMerch(merchRequest);
    }

    @DeleteMapping
    String deleteMerch(@RequestParam String merchId) {
        merchService.deleteMerchById(merchId);
        return "merch successfully deleted";
    }
}
