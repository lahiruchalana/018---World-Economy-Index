package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.ForeignReserves;
import com.example.l010myprojectsworldeconomyindex.repository.ForeignReservesRepository;
import org.springframework.stereotype.Service;

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
}
