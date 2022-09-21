package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.EconomyGrowthRate;
import com.example.l010myprojectsworldeconomyindex.repository.EconomyGrowthRateRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EconomyGrowthRateService {

    private final EconomyGrowthRateRepository economyGrowthRateRepository;

    public EconomyGrowthRateService(EconomyGrowthRateRepository economyGrowthRateRepository) {
        this.economyGrowthRateRepository = economyGrowthRateRepository;
    }

    public void addNewEconomyGrowthRateData(EconomyGrowthRate economyGrowthRate) {
        economyGrowthRateRepository.save(economyGrowthRate);
    }

//    public List<EconomyGrowthRate> getAllEconomyGrowthRateData() {
//
//    }
//
//    @Transactional
//    public void updateEconomyGrowthRateDataByCountryName() {
//
//    }
//
//    public void deleteEconomyGrowthRateDataByCountryName() {
//
//    }
//
//    public EconomyGrowthRate getEconomyGrowthRateDataByCountryName() {
//
//    }
}
