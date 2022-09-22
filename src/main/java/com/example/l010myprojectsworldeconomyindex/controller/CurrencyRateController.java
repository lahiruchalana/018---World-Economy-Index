package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import com.example.l010myprojectsworldeconomyindex.service.CurrencyRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*"
)
@RequestMapping(path = "api/data/currencies/rates")
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

    @PutMapping(path = "currencies/{currencyId}/currencyRates/{currencyRateId}")
    public ResponseEntity<?> updateCurrencyRateData(
            @PathVariable("currencyRateId") Long currencyRateId,
            @PathVariable("currencyId") Long currencyId,
            @RequestBody CurrencyRate currencyRate
            ) {
        currencyRateService.updateCurrencyRateData(currencyRateId, currencyId, currencyRate);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "currencyRates/{currencyRateId}")
    public ResponseEntity<?> updateRecordStatusOfCurrencyRateData(
            @PathVariable("currencyRateId") Long currencyRateId ,
            @RequestParam(required = false) String recordStatus
    ) {
        currencyRateService.updateRecordStatusOfCurrencyRateData(currencyRateId, recordStatus);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "currentCurrencyRates")
    public ResponseEntity<List<CurrencyRate>> getAllCurrentCurrencyRateData(
            @RequestParam(required = false) String recordStatus
    ) {
        return new ResponseEntity<>(currencyRateService.getAllCurrentCurrencyRateData(recordStatus), HttpStatus.OK);
    }

    @GetMapping(path = "currencies/{currencyName}/currentCurrencyRates")
    public ResponseEntity<Optional<CurrencyRate>> getCurrentCurrencyRateDataByCurrencyAndEqualsCurrency(
            @PathVariable("currencyName") String currencyName,
            @RequestParam(required = false) String equalsCurrencyName
            ) {
        return new ResponseEntity<>(currencyRateService.getCurrentCurrencyRateDataByCurrencyAndEqualsCurrency(currencyName, equalsCurrencyName), HttpStatus.OK);
    }

    @GetMapping(path = "currencies/{currencyName}/allCurrencyRates")
    public ResponseEntity<List<CurrencyRate>> getAllCurrencyRateDataByCurrencyAndEqualsCurrency(
            @PathVariable("currencyName") String currencyName,
            @RequestParam(required = false) String equalsCurrencyName
    ) {
        return new ResponseEntity<>(currencyRateService.getAllCurrencyRateDataByCurrencyAndEqualsCurrency(currencyName, equalsCurrencyName), HttpStatus.OK);
    }

    @DeleteMapping(path = "currencyRates/{currencyRateId}")
    public ResponseEntity<?> deleteCurrencyRateData(
            @PathVariable("currencyRateId") Long currencyRateId
    ) {
        currencyRateService.deleteCurrencyRateData(currencyRateId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
