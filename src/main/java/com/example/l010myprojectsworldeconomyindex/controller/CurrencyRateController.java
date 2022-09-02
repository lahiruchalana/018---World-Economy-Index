package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import com.example.l010myprojectsworldeconomyindex.service.CurrencyRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
