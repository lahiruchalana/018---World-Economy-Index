package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Currency;
import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRateRepository;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;
    private final CurrencyRepository currencyRepository;

    public CurrencyRateService(CurrencyRateRepository currencyRateRepository, CurrencyRepository currencyRepository) {
        this.currencyRateRepository = currencyRateRepository;
        this.currencyRepository = currencyRepository;
    }

    public void addNewCurrencyRateData(CurrencyRate currencyRate) {
        if (currencyRate.getRecordStatus().equals("current")) {
            Optional<Currency> currencyOptional = currencyRepository.findById(currencyRate.getCurrency().getCurrencyId());
            Optional<Currency> equalsCurrencyOptional = currencyRepository.findById(currencyRate.getEqualsCurrency().getCurrencyId());

            if (currencyOptional.isEmpty() || equalsCurrencyOptional.isEmpty()) {       // if currency id or equalsCurrency id does not exist
                throw new IllegalStateException("currencyId or equalsCurrencyId not exist");
            }

            Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.getCurrencyRateByCurrencyAndEqualsCurrencyAndRecordStatus(currencyOptional.get().getCurrencyName(), equalsCurrencyOptional.get().getCurrencyName(), currencyRate.getRecordStatus());

            if (currencyRateOptional.isPresent()) {         // change the "current" recordStatus to "past"
                System.out.println("currencyRateId : " + currencyRateOptional.get().getCurrencyRateId() + " currency name : " + currencyOptional.get().getCurrencyName() + " equalsCurrency name : " + equalsCurrencyOptional.get().getCurrencyName() + " recordStatus changed 'current' to 'past'");
                currencyRateOptional.get().setRecordStatus("past");     // existing "current" value change to "past"
            }

        }

        currencyRateRepository.save(currencyRate);
    }

    public List<CurrencyRate> getAllCurrencyRateData() {
        return currencyRateRepository.findAll();
    }

    public void updateRecordStatusOfCurrencyRateData() {

    }

    public void updateCurrencyRateData() {

    }

    public void deleteCurrencyRateData() {

    }

}
