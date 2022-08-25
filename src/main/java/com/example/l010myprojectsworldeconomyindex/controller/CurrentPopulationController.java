package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import com.example.l010myprojectsworldeconomyindex.service.CurrentPopulationService;
import com.example.l010myprojectsworldeconomyindex.service.PopulationService;
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

    private final PopulationService populationService;

    public CurrentPopulationController(CurrentPopulationService currentPopulationService, PopulationService populationService) {
        this.currentPopulationService = currentPopulationService;
        this.populationService = populationService;
    }

    // mostly using this method in currentPopulation, and saving a population data same time
    @PutMapping(path = "update/{countryName}/{currentPopulationValue}/{currentPopulationGrowth}/{year}")
    public ResponseEntity<?> updateCurrentPopulationData(
            @PathVariable("countryName") String countryName,
            @PathVariable("currentPopulationValue") Integer currentPopulationValue,
            @PathVariable("currentPopulationGrowth") Float currentPopulationGrowth,
            @PathVariable("year") Year year
    ) {
        currentPopulationService.updateCurrentPopulationData(countryName, currentPopulationValue, currentPopulationGrowth, year);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

                                                        // only delete the currentPopulation Data but there is a related population data in population table
    @DeleteMapping(path = "{currentPopulationId}/{populationDataIdRelatedToCurrentPopulation}")      // so should delete the data in population table -->> using populationTableDataId
    public ResponseEntity<?> deleteCurrentPopulationData(
            @PathVariable("currentPopulationId") Long currentPopulationId,
            @PathVariable("populationDataIdRelatedToCurrentPopulation") Long populationDataIdRelatedToCurrentPopulation
    ) {
        currentPopulationService.deleteCurrentPopulationData(currentPopulationId);
        populationService.deletePopulationData(populationDataIdRelatedToCurrentPopulation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
