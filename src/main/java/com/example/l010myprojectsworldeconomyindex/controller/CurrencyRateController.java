package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import com.example.l010myprojectsworldeconomyindex.service.CurrencyRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
