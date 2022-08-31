package com.example.l010myprojectsworldeconomyindex.controller;

import com.example.l010myprojectsworldeconomyindex.model.ForeignReserves;
import com.example.l010myprojectsworldeconomyindex.service.ForeignReservesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/data/foreign/reserves")
public class ForeignReservesController {

    private final ForeignReservesService foreignReservesService;

    public ForeignReservesController(ForeignReservesService foreignReservesService) {
        this.foreignReservesService = foreignReservesService;
    }

    @PostMapping
    public ResponseEntity<?> addNewForeignReservesData(
            @RequestBody ForeignReserves foreignReserves
    ) {
        foreignReservesService.addNewForeignReservesData(foreignReserves);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ForeignReserves>> getAllForeignReservesData() {
        return new ResponseEntity<>(foreignReservesService.getAllForeignReservesData(), HttpStatus.OK);
    }
}
