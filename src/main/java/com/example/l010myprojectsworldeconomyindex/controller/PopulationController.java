package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.Population;
import com.example.l010myprojectsworldeconomyindex.service.PopulationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/data/population")
public class PopulationController {

    private final PopulationService populationService;

    public PopulationController(PopulationService populationService) {
        this.populationService = populationService;
    }

    @PostMapping
    public ResponseEntity<?> addNewPopulationData(
            @RequestBody Population population
            ) {
        populationService.addNewPopulationData(population);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Population>> getAllPopulationData() {
        return new ResponseEntity<>(populationService.getAllPopulationData(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{populationId}")
    public ResponseEntity<?> deletePopulationData(
            @PathVariable("populationId") Long populationId
    ) {
        populationService.deletePopulationData(populationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
