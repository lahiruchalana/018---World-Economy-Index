package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Country;
import com.example.l010myprojectsworldeconomyindex.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;
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
        Optional<Country> countryOptional = countryRepository.findByCountryOrCountryId(country.getCountry(), country.getCountryId());

        if (countryOptional.isPresent()) {
            throw new IllegalStateException("country: " + countryOptional.get().getCountry() + " or countryId: " + countryOptional.get().getCountryId() +
                    " exists in data records, so update function is only available for this country");
        }

        countryRepository.save(country);
    }

    public Country getCountryDataByCountry(String country) {
        Optional<Country> countryOptional = countryRepository.findByCountry(country);

        if (!countryOptional.isPresent()) {
            throw new IllegalStateException("country: " + country + " does not exist, so first create the country: " + country + " record");
        }

        return countryOptional.get();
    }
}
