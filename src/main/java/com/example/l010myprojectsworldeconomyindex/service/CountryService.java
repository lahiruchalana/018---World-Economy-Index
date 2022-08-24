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

    public Country getCountryDataByCountryName(String countryName) {
        Optional<Country> countryOptional = countryRepository.findCountryByCountryName(countryName);

        // add later the "exception handling"

        return countryOptional.get();
    }

    public List<Country> getCountriesDataByCountryNameContaining(String countryName) {
        List<Country> countryList = countryRepository.findCountriesByCountryNameContaining(countryName);

        if (countryList.isEmpty()) {
            throw new IllegalStateException("country: " + countryName + " does not exist!!!");
        }

        return countryList;
    }

    public List<Country> getCountriesDataByContinentName(String continentName) {
        List<Country> countryList = countryRepository.findCountriesByContinentName(continentName);

        return countryList;
    }

    public List<Country> getCountriesDataBySubContinentName(String subContinentName) {
        List<Country> countryList = countryRepository.findCountriesBySubContinentName(subContinentName);

        return countryList;
    }


}
