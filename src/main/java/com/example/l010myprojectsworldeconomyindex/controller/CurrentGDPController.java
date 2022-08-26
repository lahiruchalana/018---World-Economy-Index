package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrentGDP;
import com.example.l010myprojectsworldeconomyindex.service.CurrentGDPService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping(path = "api/data/current/gdp")
public class CurrentGDPController {

    private final CurrentGDPService currentGDPService;

    public CurrentGDPController(CurrentGDPService currentGDPService) {
        this.currentGDPService = currentGDPService;
    }

    @PostMapping
    public ResponseEntity<?> addNewCurrentGDPData(
            @RequestBody CurrentGDP currentGDP
    ) {
        currentGDPService.addNewCurrentGDPData(currentGDP);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurrentGDP>> getAllCurrentGDPData() {
        return new ResponseEntity<>(currentGDPService.getAllCurrentGDPData(), HttpStatus.OK);
    }

    @DeleteMapping("{currentGdpId}/{isDeletingGdpValueInGDPTable}")
    public ResponseEntity<?> deleteCurrentGDPData (
            @PathVariable("currentGdpId") Long currentGdpId,
            @PathVariable("isDeletingGdpValueInGDPTable") Boolean isDeletingGdpValueInGDPTable
    ) {
        currentGDPService.deleteCurrentGDPData(currentGdpId, isDeletingGdpValueInGDPTable);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "{countryName}/{isPastGDPDataSavingInGDPTableAsAGDPData}/{currentGDPValue}/{year}/{month}")
    public ResponseEntity<?> updateCurrentGDPData (
            @PathVariable("countryName") String countryName,
            @PathVariable("isPastGDPDataSavingInGDPTableAsAGDPData") Boolean isPastGDPDataSavingInGDPTableAsAGDPData,
            @PathVariable("currentGDPValue") Integer currentGDPValue,
            @PathVariable("year") Year year,
            @PathVariable("month") Month month
            ) {
        currentGDPService.updateCurrentGDPData(countryName, isPastGDPDataSavingInGDPTableAsAGDPData, currentGDPValue, year, month);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
