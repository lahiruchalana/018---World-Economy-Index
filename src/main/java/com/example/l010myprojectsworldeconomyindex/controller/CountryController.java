package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.Country;
import com.example.l010myprojectsworldeconomyindex.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/data/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountryData() {
        return new ResponseEntity<>(countryService.getAllCountryData(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> addNewCountryData(
            @RequestBody Country country
    ) {
        countryService.addNewCountryData(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "{country}")
    public ResponseEntity<Country> getCountryDataByCountry(
            @PathVariable("country") String country
    ) {
        return new ResponseEntity<>(countryService.getCountryDataByCountry(country), HttpStatus.OK);
    }

}
