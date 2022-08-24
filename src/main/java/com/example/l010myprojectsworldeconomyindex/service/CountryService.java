package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Country;
import com.example.l010myprojectsworldeconomyindex.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountryData() {
        return countryRepository.findAll();
    }

    public void addNewCountryData(Country country) {
        Optional<Country> countryOptional = countryRepository.findByCountryNameOrCountryId(country.getCountryName(), country.getCountryId());

        if (countryOptional.isPresent()) {
            throw new IllegalStateException("country: " + countryOptional.get().getCountryName() + " or countryId: " + countryOptional.get().getCountryId() +
                    " exists in data records, so update function is only available for this country");
        }

        countryRepository.save(country);
    }

    public Country getCountryDataByCountry(String countryName) {
        Optional<Country> countryOptional = countryRepository.findByCountryName(countryName);

        if (!countryOptional.isPresent()) {
            throw new IllegalStateException("country: " + countryName + " does not exist, so first create the country: " + countryName + " record");
        }

        return countryOptional.get();
    }
}
