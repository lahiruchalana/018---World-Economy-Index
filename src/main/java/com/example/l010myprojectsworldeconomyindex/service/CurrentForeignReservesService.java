package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentForeignReserves;
import com.example.l010myprojectsworldeconomyindex.model.ForeignReserves;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentForeignReservesRepository;
import com.example.l010myprojectsworldeconomyindex.repository.ForeignReservesRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class CurrentForeignReservesService {

    private final CurrentForeignReservesRepository currentForeignReservesRepository;
    private final ForeignReservesRepository foreignReservesRepository;

    public CurrentForeignReservesService(CurrentForeignReservesRepository currentForeignReservesRepository, ForeignReservesRepository foreignReservesRepository) {
        this.currentForeignReservesRepository = currentForeignReservesRepository;
        this.foreignReservesRepository = foreignReservesRepository;
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

    public void deleteCurrentForeignReservesData(Long currentForeignReservesId, Boolean isDeletingForeignReservesValueInForeignReservesTable) {
        CurrentForeignReserves currentForeignReserves = currentForeignReservesRepository.findById(currentForeignReservesId).orElseThrow(() -> new IllegalStateException("currentForeignReserves id does not exist"));

        if (!isDeletingForeignReservesValueInForeignReservesTable) {        // if this value is "true" then both the data in two table are deleting but when it's coming to "false", there is a saving copy of data in ForeignReserves Table
            ForeignReserves foreignReserves = new ForeignReserves(currentForeignReserves.getCurrentForeignReservesValue(), currentForeignReserves.getYear(), currentForeignReserves.getMonth(), currentForeignReserves.getCountry());
            foreignReservesRepository.save(foreignReserves);
        }

        currentForeignReservesRepository.delete(currentForeignReserves);

    }

    public void updateCurrentForeignReservesData(String  countryName, Boolean isPastForeignReservesDataSavingInForeignReservesTableAsForeignReservesData, Integer currentForeignReservesValue, Year year, Month month) {
        Optional<CurrentForeignReserves> currentForeignReservesOptional = currentForeignReservesRepository.findCurrentForeignReservesByCountryName(countryName);

        if (currentForeignReservesOptional.isEmpty()) {
            throw new IllegalStateException("country : " + countryName + "does not exist");
        }
        if (isPastForeignReservesDataSavingInForeignReservesTableAsForeignReservesData) {
            ForeignReserves foreignReserves = new ForeignReserves(currentForeignReservesOptional.get().getCurrentForeignReservesValue(), currentForeignReservesOptional.get().getYear(), currentForeignReservesOptional.get().getMonth(), currentForeignReservesOptional.get().getCountry());

            foreignReservesRepository.save(foreignReserves);
        }

        currentForeignReservesOptional.get().setCurrentForeignReservesValue(currentForeignReservesValue);
        currentForeignReservesOptional.get().setYear(year);
        currentForeignReservesOptional.get().setMonth(month);

        currentForeignReservesOptional.get().getForeignReserves().setForeignReservesValue(currentForeignReservesValue);
        currentForeignReservesOptional.get().getForeignReserves().setYear(year);
        currentForeignReservesOptional.get().getForeignReserves().setMonth(month);
    }


}
