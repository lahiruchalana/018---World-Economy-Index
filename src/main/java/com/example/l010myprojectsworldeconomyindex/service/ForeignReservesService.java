package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Country;
import com.example.l010myprojectsworldeconomyindex.model.ForeignReserves;
import com.example.l010myprojectsworldeconomyindex.repository.CountryRepository;
import com.example.l010myprojectsworldeconomyindex.repository.ForeignReservesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Month;
import java.time.Year;
import java.util.List;

@Service
public class ForeignReservesService {

    private final ForeignReservesRepository foreignReservesRepository;
    private final CountryRepository countryRepository;

    public ForeignReservesService(ForeignReservesRepository foreignReservesRepository, CountryRepository countryRepository) {
        this.foreignReservesRepository = foreignReservesRepository;
        this.countryRepository = countryRepository;
    }

    public void addNewForeignReservesData(ForeignReserves foreignReserves) {
        foreignReservesRepository.save(foreignReserves);
    }

    public List<ForeignReserves> getAllForeignReservesData() {
        return foreignReservesRepository.findAll();
    }

    @Transactional
    public void updateForeignReservesData(Long foreignReservesId, Integer foreignReservesValue, Year year, Month month, Long countryId) {
        ForeignReserves foreignReserves = foreignReservesRepository.findById(foreignReservesId).orElseThrow(() -> new IllegalStateException("ForeignReserves id does not exist"));

        Country country = countryRepository.findById(countryId).orElseThrow(() -> new IllegalStateException("countryId does not exist"));

        if (foreignReservesValue != null) {
            foreignReserves.setForeignReservesValue(foreignReservesValue);
        }

        if (year != null) {
            foreignReserves.setYear(year);
        }

        if (month != null) {
            foreignReserves.setMonth(month);
        }

        foreignReserves.setCountry(country);
    }

    public void deleteForeignReservesData(Long foreignReservesId) {
        ForeignReserves foreignReserves = foreignReservesRepository.findById(foreignReservesId).orElseThrow(() -> new IllegalStateException("ForeignReserves id does not exist"));

        foreignReservesRepository.delete(foreignReserves);
    }

}
