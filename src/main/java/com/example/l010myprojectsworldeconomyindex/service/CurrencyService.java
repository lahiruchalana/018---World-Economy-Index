package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Currency;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void addNewCurrencyData(Currency currency) {
        currencyRepository.save(currency);
    }

}
