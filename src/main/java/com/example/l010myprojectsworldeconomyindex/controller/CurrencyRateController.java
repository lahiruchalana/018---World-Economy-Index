package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import com.example.l010myprojectsworldeconomyindex.service.CurrencyRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/data/currency/rate")
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    public CurrencyRateController(CurrencyRateService currencyRateService) {
        this.currencyRateService = currencyRateService;
    }

    @PostMapping
    public ResponseEntity<?> addNewCurrencyRateData(
            @RequestBody CurrencyRate currencyRate
            ) {
        currencyRateService.addNewCurrencyRateData(currencyRate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurrencyRate>> getAllCurrencyRateData() {
        return new ResponseEntity<>(currencyRateService.getAllCurrencyRateData(), HttpStatus.OK);
    }

    @PutMapping(path = "update/{currencyRateId}/{currencyRateValue}/{recordStatus}/{year}/{month}/{currencyId}/{equalsCurrencyId}")
    public ResponseEntity<?> updateCurrencyRateData(
            @PathVariable("currencyRateId") Long currencyRateId,
            @PathVariable("currencyRateValue") Float currencyRateValue,
            @PathVariable("recordStatus") String recordStatus,
            @PathVariable("year") Year year,
            @PathVariable("month") Month month,
            @PathVariable("currencyId") Long currencyId,
            @PathVariable("equalsCurrencyId") Long equalsCurrencyId
            ) {
        currencyRateService.updateCurrencyRateData(currencyRateId,currencyRateValue,recordStatus, year, month, currencyId, equalsCurrencyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "{currencyRateId}/{recordStatus}")
    public ResponseEntity<?> updateRecordStatusOfCurrencyRateData(
            @PathVariable("currencyRateId") Long currencyRateId ,
            @PathVariable("recordStatus") String recordStatus
    ) {
        currencyRateService.updateRecordStatusOfCurrencyRateData(currencyRateId, recordStatus);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "recordStatus/{recordStatus}")
    public ResponseEntity<List<CurrencyRate>> getAllCurrentCurrencyRateData(
            @PathVariable("recordStatus") String recordStatus
    ) {
        return new ResponseEntity<>(currencyRateService.getAllCurrentCurrencyRateData(recordStatus), HttpStatus.OK);
    }

    @GetMapping(path = "current/{currencyName}/{equalsCurrencyName}")
    public ResponseEntity<Optional<CurrencyRate>> getCurrentCurrencyRateDataByCurrencyAndEqualsCurrency(
            @PathVariable("currencyName") String currencyName,
            @PathVariable("equalsCurrencyName") String equalsCurrencyName
    ) {
        return new ResponseEntity<>(currencyRateService.getCurrentCurrencyRateDataByCurrencyAndEqualsCurrency(currencyName, equalsCurrencyName), HttpStatus.OK);
    }

    @GetMapping(path = "all/{currencyName}/{equalsCurrencyName}")
    public ResponseEntity<List<CurrencyRate>> getAllCurrencyRateDataByCurrencyAndEqualsCurrency(
            @PathVariable("currencyName") String currencyName,
            @PathVariable("equalsCurrencyName") String equalsCurrencyName
    ) {
        return new ResponseEntity<>(currencyRateService.getAllCurrencyRateDataByCurrencyAndEqualsCurrency(currencyName, equalsCurrencyName), HttpStatus.OK);
    }
}
