package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.EconomyGrowthRate;
import com.example.l010myprojectsworldeconomyindex.service.EconomyGrowthRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/data/economy/growth/rate")
public class EconomyGrowthRateController {

    private final EconomyGrowthRateService economyGrowthRateService;

    public EconomyGrowthRateController(EconomyGrowthRateService economyGrowthRateService) {
        this.economyGrowthRateService = economyGrowthRateService;
    }

//    @PostMapping
//    public ResponseEntity<EconomyGrowthRate> addNewEconomyGrowthRateData(
//            @RequestBody EconomyGrowthRate economyGrowthRate
//    ) {
//
//    }
}
