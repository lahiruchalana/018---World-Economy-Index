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
    public ResponseEntity<?> addNewCountryData(
            @RequestBody Country country
    ) {
        countryService.addNewCountryData(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "one_country_record/{countryName}")
    public ResponseEntity<Country> getCountryDataByCountryName(
            @PathVariable("countryName") String countryName
    ) {
        return new ResponseEntity<>(countryService.getCountryDataByCountryName(countryName), HttpStatus.OK);
    }

    @GetMapping(path = "containing/{countryName}")
    public ResponseEntity<List<Country>> getCountriesDataByCountryNameContaining(
            @PathVariable("countryName") String countryName
    ) {
        return new ResponseEntity<>(countryService.getCountriesDataByCountryNameContaining(countryName), HttpStatus.OK);
    }

    @GetMapping("continent/{continentName}")
    public ResponseEntity<List<Country>> getCountriesDataByContinentName(
            @PathVariable("continentName") String continentName
    ) {
        return new ResponseEntity<>(countryService.getCountriesDataByContinentName(continentName), HttpStatus.OK);
    }

    @GetMapping(path = "sub_continent/{subContinentName}")
    public ResponseEntity<List<Country>> getCountriesDataBySubContinentName(
            @PathVariable("subContinentName") String subContinentName
    ) {
        return new ResponseEntity<>(countryService.getCountriesDataBySubContinentName(subContinentName), HttpStatus.OK);
    }

}
