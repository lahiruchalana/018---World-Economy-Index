package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentForeignReserves;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentForeignReservesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentForeignReservesService {

    private final CurrentForeignReservesRepository currentForeignReservesRepository;

    public CurrentForeignReservesService(CurrentForeignReservesRepository currentForeignReservesRepository) {
        this.currentForeignReservesRepository = currentForeignReservesRepository;
    }

    public void addNewCurrentForeignReservesData(CurrentForeignReserves currentForeignReserves) {
        currentForeignReservesRepository.save(currentForeignReserves);
    }

    public List<CurrentForeignReserves> getAllCurrentForeignReservesData() {
        return currentForeignReservesRepository.findAll();
    }
}
