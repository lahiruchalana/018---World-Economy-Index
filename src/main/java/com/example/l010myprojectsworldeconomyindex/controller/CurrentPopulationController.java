package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import com.example.l010myprojectsworldeconomyindex.service.CurrentPopulationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping(path = "api/data/population/current")
public class CurrentPopulationController {

    private final CurrentPopulationService currentPopulationService;

    public CurrentPopulationController(CurrentPopulationService currentPopulationService) {
        this.currentPopulationService = currentPopulationService;
    }

    @PostMapping
    public ResponseEntity<?> addCurrentPopulationData(@RequestBody CurrentPopulation currentPopulation) {
        currentPopulationService.addCurrentPopulationData(currentPopulation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurrentPopulation>> getAllCurrentPopulationData() {
        return new ResponseEntity<>(currentPopulationService.getALlCurrentPopulationData(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{currentPopulationId}")
    public ResponseEntity<?> deleteCurrentPopulationData(
            @PathVariable("currentPopulationId") Long currentPopulationId ) {
        currentPopulationService.deleteCurrentPopulationData(currentPopulationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "{country}")
    public ResponseEntity<?> updateCurrentPopulationData(
            @PathVariable("country") String country,
            @RequestParam(required = true) Integer currentPopulation,
            @RequestParam(required = true) Year updatedYear
            ) {
        currentPopulationService.updateCurrentPopulationData(country, currentPopulation, updatedYear);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
