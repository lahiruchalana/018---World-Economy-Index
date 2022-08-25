package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import com.example.l010myprojectsworldeconomyindex.service.CurrentPopulationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/data/current/population")
public class CurrentPopulationController {

    private final CurrentPopulationService currentPopulationService;

    public CurrentPopulationController(CurrentPopulationService currentPopulationService) {
        this.currentPopulationService = currentPopulationService;
    }

    @PostMapping
    public ResponseEntity<?> addNewCurrentPopulationData(@RequestBody CurrentPopulation currentPopulation) {
        currentPopulationService.addNewCurrentPopulationData(currentPopulation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurrentPopulation>> getAllCurrentPopulationData() {
        return new ResponseEntity<>(currentPopulationService.getALlCurrentPopulationData(), HttpStatus.OK);
    }

    @GetMapping(path = "{countryName}")
    public ResponseEntity<Optional<CurrentPopulation>> getCurrentPopulationDataByCountry(
            @PathVariable("countryName") String countryName
    ) {
        return new ResponseEntity<>(currentPopulationService.getCurrentPopulationDataByCountryName(countryName), HttpStatus.OK);
    }

//    @DeleteMapping(path = "{currentPopulationId}")
//    public ResponseEntity<?> deleteCurrentPopulationData(
//            @PathVariable("currentPopulationId") Long currentPopulationId ) {
//        currentPopulationService.deleteCurrentPopulationData(currentPopulationId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping(path = "{country}")
//    public ResponseEntity<?> updateCurrentPopulationData(
//            @PathVariable("country") String country,
//            @RequestParam(required = true) Integer currentPopulation,
//            @RequestParam(required = true) Year updatedYear
//            ) {
//        currentPopulationService.updateCurrentPopulationData(country, currentPopulation, updatedYear);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
