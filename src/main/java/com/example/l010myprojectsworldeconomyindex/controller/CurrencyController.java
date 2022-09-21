package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.Currency;
import com.example.l010myprojectsworldeconomyindex.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*"
)
@RequestMapping(path = "api/data/currencies")
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

    @GetMapping
    public ResponseEntity<List<Currency>> getAllCurrencyData() {
        return new ResponseEntity<>(currencyService.getAllCurrencyData(), HttpStatus.OK);
    }

    @PutMapping(path = "currencies/{countryName}")
    public ResponseEntity<?> updateCountryListInCurrencyData(
            @PathVariable("countryName") String countryName,
            @RequestBody Currency currency
    ) {
        currencyService.updateCountryListInCurrencyData(countryName, currency);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
