package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.repository.EconomyGrowthRateRepository;
import org.springframework.stereotype.Service;

@Service
public class EconomyGrowthRateService {

    private final EconomyGrowthRateRepository economyGrowthRateRepository;

    public EconomyGrowthRateService(EconomyGrowthRateRepository economyGrowthRateRepository) {
        this.economyGrowthRateRepository = economyGrowthRateRepository;
    }
}
