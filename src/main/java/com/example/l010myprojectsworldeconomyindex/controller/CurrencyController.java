package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.Currency;
import com.example.l010myprojectsworldeconomyindex.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/data/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping
    public ResponseEntity<?> addNewCurrencyData(
            @RequestBody Currency currency
            ) {
        currencyService.addNewCurrencyData(currency);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
