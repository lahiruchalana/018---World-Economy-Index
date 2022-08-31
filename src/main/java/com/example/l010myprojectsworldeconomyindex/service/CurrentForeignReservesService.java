package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentForeignReserves;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentForeignReservesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrentForeignReservesService {

    private final CurrentForeignReservesRepository currentForeignReservesRepository;

    public CurrentForeignReservesService(CurrentForeignReservesRepository currentForeignReservesRepository) {
        this.currentForeignReservesRepository = currentForeignReservesRepository;
    }

    public void addNewCurrentForeignReservesData(CurrentForeignReserves currentForeignReserves) {
        Optional<CurrentForeignReserves> currentForeignReservesOptional = currentForeignReservesRepository.findCurrentForeignReservesByCountryName(currentForeignReserves.getCountry().getCountryName());

        if (currentForeignReservesOptional.isPresent()) {
            throw new IllegalStateException("country : " + currentForeignReserves.getCountry().getCountryName() + " is existing in the table, so update it");
        } else if (currentForeignReserves.getCurrentForeignReservesValue().intValue() != currentForeignReserves.getForeignReserves().getForeignReservesValue()) {
            throw new IllegalStateException("currentForeignReservesValue : " + currentForeignReserves.getCurrentForeignReservesValue() + " and foreignReservesValue : " + currentForeignReserves.getForeignReserves().getForeignReservesValue() + " does not same!");
        } else if (currentForeignReserves.getCountry().getCountryId().intValue() != currentForeignReserves.getForeignReserves().getCountry().getCountryId()) {
            throw new IllegalStateException("country in CurrentForeignReserves : " + currentForeignReserves.getCountry().getCountryId().intValue() + " and country in ForeignReserves : " + currentForeignReserves.getForeignReserves().getCountry().getCountryId() + " does not same!");
        } else if (!currentForeignReserves.getYear().toString().equals(currentForeignReserves.getForeignReserves().getYear().toString())) {
            throw new IllegalStateException("year in CurrentForeignReserves : " + currentForeignReserves.getYear() + "  and year in ForeignReserves : " + currentForeignReserves.getForeignReserves().getYear() + " does not same!");
        } else if (currentForeignReserves.getMonth() != currentForeignReserves.getForeignReserves().getMonth()) {
            throw new IllegalStateException("month in CurrentForeignReserves : " + currentForeignReserves.getMonth() + "  and month in ForeignReserves : " + currentForeignReserves.getForeignReserves().getMonth() + " does not same!");
        }

        currentForeignReservesRepository.save(currentForeignReserves);
    }

    public List<CurrentForeignReserves> getAllCurrentForeignReservesData() {
        return currentForeignReservesRepository.findAll();
    }
}
