package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.service.GDPService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping(path = "api/data/gdp")
public class GDPController {

    private final GDPService gdpService;

    public GDPController(GDPService gdpService) {
        this.gdpService = gdpService;
    }

    @PostMapping
    public ResponseEntity<?> addNewGDPData(
            @RequestBody GDP gdp
    ) {
        gdpService.addNewGDPData(gdp);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GDP>> getAllGDPData() {
        return new ResponseEntity<>(gdpService.getAllGDPData(), HttpStatus.OK);
    }
//
//    @GetMapping(path = "{country}")
//    public ResponseEntity<List<GDP>> getGDPByCountry(@PathVariable("country") String country) {
//        return new ResponseEntity<>(gdpService.getGDPByCountry(country), HttpStatus.OK);
//    }
//
//    @GetMapping(path = "/country/and/year/between")
//    public ResponseEntity<List<GDP>> getGDPDataByCountryAndYearBetween(
//            @RequestParam(required = true) String country,
//            @RequestParam(required = true) YearMonth yearMonthStart,
//            @RequestParam(required = true) YearMonth yearMonthEnd) {
//        return new ResponseEntity<>(gdpService.getGDPDataByCountryAndYearBetween(country, yearMonthStart, yearMonthEnd), HttpStatus.OK);
//    }
//
//    @PutMapping(path = "{gdpId}")
//    public ResponseEntity<?> updateGDPData(
//            @PathVariable("gdpId") Long gdpId,
//            @RequestParam(required = false) Integer gdpValue,
//            @RequestParam(required = false) YearMonth year) {
//        gdpService.updateGDPData(gdpId, gdpValue, year);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping(path = "{gdpId}")
//    public ResponseEntity<?> deleteGDPData(
//            @PathVariable("gdpId") Long gdpId ) {
//        gdpService.deleteGDPData(gdpId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping(path = "/compare")
//    public ResponseEntity<List<GDP>> getGDPDataByManyCountries(
//            @RequestParam(required = false) String countryOne,
//            @RequestParam(required = false) String countryTwo,
//            @RequestParam(required = false) String countryThree,
//            @RequestParam(required = false) String countryFour
//    ) {
//        return new ResponseEntity<>(gdpService.getGDPDataByManyCountries(countryOne, countryTwo, countryThree, countryFour), HttpStatus.OK);
//    }

}
