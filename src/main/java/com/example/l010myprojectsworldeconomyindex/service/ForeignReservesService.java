package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.ForeignReserves;
import com.example.l010myprojectsworldeconomyindex.repository.ForeignReservesRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;
import java.util.List;

@Service
public class ForeignReservesService {

    private final ForeignReservesRepository foreignReservesRepository;

    public ForeignReservesService(ForeignReservesRepository foreignReservesRepository) {
        this.foreignReservesRepository = foreignReservesRepository;
    }

    public void addNewForeignReservesData(ForeignReserves foreignReserves) {
        foreignReservesRepository.save(foreignReserves);
    }

    public List<ForeignReserves> getAllForeignReservesData() {
        return foreignReservesRepository.findAll();
    }

    public void updateForeignReservesData(Long foreignReservesId, Integer foreignReservesValue, Year year, Month month) {
        ForeignReserves foreignReserves = foreignReservesRepository.findById(foreignReservesId).orElseThrow(() -> new IllegalStateException("ForeignReserves id does not exist"));


    }
}
