package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Country;
import com.example.l010myprojectsworldeconomyindex.model.Currency;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void addNewCurrencyData(Currency currency) {
        currencyRepository.save(currency);
    }

    public List<Currency> getAllCurrencyData() {
        return currencyRepository.findAll();
    }

    @Transactional
    public void updateCountryListInCurrencyData(String currencyName, Currency currency) {
        Optional<Currency> currencyOptional = currencyRepository.findCurrencyByCurrencyName(currencyName);

        if (!currencyOptional.isPresent()) {
            throw new IllegalStateException("currency : " + currencyName + " does not exist");
        }

        currencyOptional.get().setCountryList(currency.getCountryList());
        currencyOptional.get().setCurrencyName(currency.getCurrencyName());
    }
}
