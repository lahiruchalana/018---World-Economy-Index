package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import com.example.l010myprojectsworldeconomyindex.service.CurrentPopulationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
