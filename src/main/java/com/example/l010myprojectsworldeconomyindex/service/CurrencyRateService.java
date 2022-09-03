package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Currency;
import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRateRepository;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Month;
import java.time.Year;
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

    @Transactional
    public void updateCurrencyRateData(Long currencyRateId, Float currencyRateValue, String recordStatus, Year year, Month month, Long currencyId, Long equalsCurrencyId) {
        CurrencyRate currencyRate = currencyRateRepository.findById(currencyRateId).orElseThrow(() -> new IllegalStateException("currencyRate id : " + currencyRateId + " does not exist"));

        Currency currency = currencyRepository.findById(currencyId).orElseThrow(() -> new IllegalStateException("currencyId not exist"));
        Currency equalsCurrency = currencyRepository.findById(equalsCurrencyId).orElseThrow(() -> new IllegalStateException("equalsCurrencyId not exist"));

        if (recordStatus.equals("current")) {
            Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.getCurrencyRateByCurrencyAndEqualsCurrencyAndRecordStatus(currency.getCurrencyName(), equalsCurrency.getCurrencyName(), recordStatus);

            currencyRateOptional.ifPresent(rate -> rate.setRecordStatus("past"));
        }


        currencyRate.setCurrencyRateValue(currencyRateValue);
        currencyRate.setRecordStatus(recordStatus);
        currencyRate.setYear(year);
        currencyRate.setMonth(month);
        currencyRate.setCurrency(currency);
        currencyRate.setEqualsCurrency(equalsCurrency);

    }

    @Transactional
    public void updateRecordStatusOfCurrencyRateData(Long currencyRateId, String recordStatus) {
        Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.findById(currencyRateId);

        if (currencyRateOptional.isEmpty()) {
            throw new IllegalStateException("currencyRate id does not exist");
        }

        if (recordStatus.equals("current")) {
            Optional<CurrencyRate> currencyRateOptionalSecond = currencyRateRepository.getCurrencyRateByCurrencyAndEqualsCurrencyAndRecordStatus(currencyRateOptional.get().getCurrency().getCurrencyName(), currencyRateOptional.get().getEqualsCurrency().getCurrencyName(), recordStatus);

            currencyRateOptionalSecond.ifPresent(rate -> rate.setRecordStatus("past"));
        }

        currencyRateOptional.get().setRecordStatus(recordStatus);
    }

    public void deleteCurrencyRateData() {

    }

}
