package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyRateService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    public void addNewCurrencyRateData(CurrencyRate currencyRate) {
        currencyRateRepository.save(currencyRate);
    }

    public List<CurrencyRate> getAllCurrencyRateData() {
        return currencyRateRepository.findAll();
    }

}
