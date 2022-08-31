package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.CurrentForeignReserves;
import com.example.l010myprojectsworldeconomyindex.service.CurrentForeignReservesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/data/current/foreign/reserves")
public class CurrentForeignReservesController {

    private final CurrentForeignReservesService currentForeignReservesService;

    public CurrentForeignReservesController(CurrentForeignReservesService currentForeignReservesService) {
        this.currentForeignReservesService = currentForeignReservesService;
    }

    @PostMapping
    public ResponseEntity<?> addNewCurrentForeignReservesData(
            @RequestBody CurrentForeignReserves currentForeignReserves
    ) {
        currentForeignReservesService.addNewCurrentForeignReservesData(currentForeignReserves);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurrentForeignReserves>> getAllCurrentForeignReservesData() {
        return new ResponseEntity<>(currentForeignReservesService.getAllCurrentForeignReservesData(), HttpStatus.OK);
    }

    @DeleteMapping(path = "{currentForeignReservesId}/{isDeletingForeignReservesValueInForeignReservesTable}")
    public ResponseEntity<?> deleteCurrentForeignReservesData(
            @PathVariable("currentForeignReservesId") Long currentForeignReservesId,
            @PathVariable("isDeletingForeignReservesValueInForeignReservesTable") Boolean isDeletingForeignReservesValueInForeignReservesTable
    ) {
        currentForeignReservesService.deleteCurrentForeignReservesData(currentForeignReservesId, isDeletingForeignReservesValueInForeignReservesTable);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
