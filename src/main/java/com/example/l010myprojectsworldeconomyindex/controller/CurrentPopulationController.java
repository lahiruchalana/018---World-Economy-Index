package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import com.example.l010myprojectsworldeconomyindex.service.CurrentPopulationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/data/population/current")
public class CurrentPopulationController {

    private final CurrentPopulationService currentPopulationService;

    public CurrentPopulationController(CurrentPopulationService currentPopulationService) {
        this.currentPopulationService = currentPopulationService;
    }

    @PostMapping
    public ResponseEntity<CurrentPopulation> addCurrentPopulationData(@RequestBody CurrentPopulation currentPopulation) {
        currentPopulationService.addCurrentPopulationData(currentPopulation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
