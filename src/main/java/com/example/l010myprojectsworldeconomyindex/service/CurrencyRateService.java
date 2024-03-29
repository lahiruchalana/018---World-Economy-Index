package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.exceptions.DataExistingException;
import com.example.l010myprojectsworldeconomyindex.model.Currency;
import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRateRepository;
import com.example.l010myprojectsworldeconomyindex.repository.CurrencyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        if(currencyRate.getCurrency().getCurrencyId().equals(currencyRate.getEqualsCurrency().getCurrencyId())) {
            throw new IllegalStateException("adding currencyRate currencyID : " + currencyRate.getCurrency().getCurrencyId() + " and equalsCurrencyId : " + currencyRate.getEqualsCurrency().getCurrencyId() + " are same.");
        }

        Optional<CurrencyRate> optionalCurrencyRate = currencyRateRepository.getCurrencyRatesByYearAndMonthAndDateAndCurrencyCurrencyIdAndEqualsCurrencyCurrencyId(currencyRate.getYear(), currencyRate.getMonth(), currencyRate.getDate(), currencyRate.getCurrency().getCurrencyId(), currencyRate.getEqualsCurrency().getCurrencyId());

        if (optionalCurrencyRate.isPresent()) {
            throw new DataExistingException("not allowed to have many records for a date");
        }

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
    public void updateCurrencyRateData(Long currencyRateId, Long currencyId, CurrencyRate currencyRateNew) {
        if(currencyId.equals(currencyRateNew.getEqualsCurrency().getCurrencyId())) {
            throw new IllegalStateException("new currencyRate currency : " + currencyId + " and equalsCurrency : " + currencyRateNew.getEqualsCurrency().getCurrencyName() + " are same.");
        }

        Optional<CurrencyRate> optionalCurrencyRate = currencyRateRepository.getCurrencyRatesByYearAndMonthAndDateAndCurrencyCurrencyIdAndEqualsCurrencyCurrencyId(currencyRateNew.getYear(), currencyRateNew.getMonth(), currencyRateNew.getDate(), currencyId, currencyRateNew.getEqualsCurrency().getCurrencyId());

        if (optionalCurrencyRate.isPresent() && !currencyRateId.equals(optionalCurrencyRate.get().getCurrencyRateId())) {
            throw new IllegalStateException("existing currency rate available for relevant " + currencyRateNew.getYear() + "-" + currencyRateNew.getMonth() + "-" + currencyRateNew.getDate() +" date, so please change year, month, date or update");
        }

        CurrencyRate currencyRate = currencyRateRepository.findById(currencyRateId).orElseThrow(() -> new IllegalStateException("currencyRate id : " + currencyRateId + " does not exist"));

        Currency currency = currencyRepository.findById(currencyId).orElseThrow(() -> new IllegalStateException("currencyId not exist"));
        Currency equalsCurrency = currencyRepository.findById(currencyRateNew.getEqualsCurrency().getCurrencyId()).orElseThrow(() -> new IllegalStateException("equalsCurrencyId not exist"));

        if (currencyRateNew.getRecordStatus().equals("current")) {
            Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.getCurrencyRateByCurrencyAndEqualsCurrencyAndRecordStatus(currency.getCurrencyName(), equalsCurrency.getCurrencyName(), currencyRateNew.getRecordStatus());

            currencyRateOptional.ifPresent(rate -> rate.setRecordStatus("past"));
        }


        currencyRate.setCurrencyRateValue(currencyRateNew.getCurrencyRateValue());
        currencyRate.setRecordStatus(currencyRateNew.getRecordStatus());
        currencyRate.setYear(currencyRateNew.getYear());
        currencyRate.setMonth(currencyRateNew.getMonth());
        currencyRate.setDate(currencyRateNew.getDate());
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

    public List<CurrencyRate> getAllCurrentCurrencyRateData(String recordStatus) {
        return currencyRateRepository.getCurrencyRatesByRecordStatus(recordStatus);
    }

    public Optional<CurrencyRate> getCurrentCurrencyRateDataByCurrencyAndEqualsCurrency(String currencyName, String equalsCurrencyName) {
        Optional<CurrencyRate> currencyRateOptional = currencyRateRepository.getCurrencyRateByCurrencyAndEqualsCurrencyAndRecordStatus(currencyName, equalsCurrencyName, "current");

        if (currencyRateOptional.isEmpty()) {
            throw new IllegalStateException("currencyName : " + currencyName + " equalsCurrencyName : " + equalsCurrencyName + " does not exist a current value");
        }

        return currencyRateOptional;
    }

    public List<CurrencyRate> getAllCurrencyRateDataByCurrencyAndEqualsCurrency(String currencyName, String  equalsCurrencyName, String sortingProperty, String order) {

        // sorting by year-month-day in ascending for initial loading of all data by currency and equals currency
        List<CurrencyRate> currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByYearAscMonthAscDateAsc(currencyName, equalsCurrencyName);

        // sorting by year-month-day in descending for initial loading of all data by currency and equals currency
        if (sortingProperty.equals("Date") && order.equals("Desc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByYearDescMonthDescDateDesc(currencyName, equalsCurrencyName);
        } else if (sortingProperty.equals("Value") && order.equals("Asc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateValueAsc(currencyName, equalsCurrencyName);
        } else if (sortingProperty.equals("Value") && order.equals("Desc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateValueDesc(currencyName, equalsCurrencyName);
        } else if (sortingProperty.equals("Id") && order.equals("Asc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateIdAsc(currencyName, equalsCurrencyName);
        } else if (sortingProperty.equals("Id") && order.equals("Desc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateIdDesc(currencyName, equalsCurrencyName);
        }

        if (currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName.isEmpty()) {
            throw new IllegalStateException("currencyName : " + currencyName + " and equalsCurrencyName : " + equalsCurrencyName + " does not exist any CurrencyRate Data");
        }

        return currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName;
    }

    public void deleteCurrencyRateData(Long currencyRateId) {
        CurrencyRate currencyRate = currencyRateRepository.findById(currencyRateId).orElseThrow(() -> new IllegalStateException("currencyRate id : " + currencyRateId + " does not exist"));

        currencyRateRepository.delete(currencyRate);
    }

    public Page<CurrencyRate> getAllWithPagination(String currencyName, String equalsCurrencyName, Integer pageNumber, Integer pageSize, String sortingProperty, String order) {      // pagination
        // sorting and pagination by year-month-day in ascending for initial loading of all data by currency and equals currency (pagination)
        Page<CurrencyRate> currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByYearAscMonthAscDateAsc(currencyName, equalsCurrencyName, PageRequest.of(pageNumber, pageSize));

        // sorting and pagination by year-month-day in descending for initial loading of all data by currency and equals currency (pagination)
        if (sortingProperty.equals("Date") && order.equals("Desc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByYearDescMonthDescDateDesc(currencyName, equalsCurrencyName, PageRequest.of(pageNumber, pageSize));
        } else if (sortingProperty.equals("Value") && order.equals("Asc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateValueAsc(currencyName, equalsCurrencyName, PageRequest.of(pageNumber, pageSize));
        } else if (sortingProperty.equals("Value") && order.equals("Desc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateValueDesc(currencyName, equalsCurrencyName, PageRequest.of(pageNumber, pageSize));
        } else if (sortingProperty.equals("Id") && order.equals("Asc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateIdAsc(currencyName, equalsCurrencyName, PageRequest.of(pageNumber, pageSize));
        } else if (sortingProperty.equals("Id") && order.equals("Desc")) {
            currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName = currencyRateRepository.getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateIdDesc(currencyName, equalsCurrencyName, PageRequest.of(pageNumber, pageSize));
        }

        return currencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName;

    }

}
