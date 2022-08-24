package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.service.GDPService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
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

    @GetMapping(path = "{countryName}")
    public ResponseEntity<List<GDP>> getGDPDataByCountryName(
            @PathVariable("countryName") String countryName
    ) {
        return new ResponseEntity<>(gdpService.getGDPDataByCountryName(countryName), HttpStatus.OK);
    }

    @GetMapping(path = "{countryName}/{year}")
    public ResponseEntity<List<GDP>> getGDPDataByCountryNameAndYear(
            @PathVariable("countryName") String countryName,
            @PathVariable("year")Year year
            ) {
        return new ResponseEntity<>(gdpService.getGDPDataByCountryNameAndYear(countryName, year), HttpStatus.OK);
    }

    @PutMapping(path = "update/{gdpId}/{gdpValue}/{year}")
    public ResponseEntity<?> updateGDPData(
            @PathVariable("gdpId") Long gdpId,
            @PathVariable("gdpValue") Integer gdpValue,
            @PathVariable("year") Year year
    ) {
        gdpService.updateGDPData(gdpId, gdpValue, year);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{gdpId}")
    public ResponseEntity<?> deleteGDPData(
            @PathVariable("gdpId") Long gdpId ) {
        gdpService.deleteGDPData(gdpId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

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
