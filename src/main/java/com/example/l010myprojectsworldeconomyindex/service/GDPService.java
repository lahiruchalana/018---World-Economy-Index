package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Country;
import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.repository.CountryRepository;
import com.example.l010myprojectsworldeconomyindex.repository.GDPRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class GDPService {

    private final GDPRepository gdpRepository;
    private final CountryRepository countryRepository;

    public GDPService(GDPRepository gdpRepository, CountryRepository countryRepository) {
        this.gdpRepository = gdpRepository;
        this.countryRepository = countryRepository;
    }

    public void addNewGDPData(GDP gdp) {
        gdpRepository.save(gdp);
    }

    public List<GDP> getAllGDPData() {
        return gdpRepository.findAll();
    }

    public List<GDP> getGDPDataByCountryName(String countryName) {
        List<GDP> gdpList = gdpRepository.findGDPSByCountryName(countryName);

        if (gdpList.isEmpty()) {
            throw new IllegalStateException("country: " + countryName + " does not exist");
        }

        return gdpList;
    }

    public List<GDP> getGDPDataByCountryNameAndYear(String countryName, Year year) {
        List<GDP> gdpList = gdpRepository.findGDPSByCountryCountryNameAndYear(countryName, year);

        if (gdpList.isEmpty()) {
            throw new IllegalStateException("country: " + countryName + " has no any recorded GDP data in " + year + " year");
        }

        return gdpList;
    }

    @Transactional
    public void updateGDPData(Long gdpId, Integer gdpValue, Year year, Month month, Long countryId) {
        GDP gdp = gdpRepository.findById(gdpId).orElseThrow(() -> new IllegalStateException("gdpId:" + gdpId + " does not exist"));

        Country country = countryRepository.findById(countryId).orElseThrow(() -> new IllegalStateException("country id does not exist"));

        if (gdpValue != null && gdpValue > 0) {
            gdp.setGdpValue(gdpValue);
        }

        if (year != null) {
            gdp.setYear(year);
        }

        if (month != null) {
            gdp.setMonth(month);
        }

        gdp.setCountry(country);

    }

    public void deleteGDPData(Long gdpId) {
        GDP gdp = gdpRepository.findById(gdpId).orElseThrow(() -> new IllegalStateException(
                "id: " + gdpId + " does not exist"
        ));

        System.out.println(gdpId);
        gdpRepository.delete(gdp);
    }

    public List<GDP> getGDPDataByManyCountries(String countryOne, String countryTwo, String countryThree, String countryFour) {
        List<GDP> countryOneGDP = gdpRepository.findGDPSByCountryName(countryOne);
        List<GDP> countryTwoGDP = gdpRepository.findGDPSByCountryName(countryTwo);
        List<GDP> countryThreeGDP = gdpRepository.findGDPSByCountryName(countryThree);
        List<GDP> countryFourGDP = gdpRepository.findGDPSByCountryName(countryFour);

        if (countryOneGDP.isEmpty() && countryOne != null) {
            throw new IllegalStateException("country: " + countryOne + " does not exist. add other country or remove " + countryOne + ".");
        } else if (countryTwoGDP.isEmpty() && countryTwo != null) {
            throw new IllegalStateException("country: " + countryTwo + " does not exist. add other country or remove " + countryTwo + ".");
        } else if (countryThreeGDP.isEmpty() && countryThree != null) {
            throw new IllegalStateException("country: " + countryThree + " does not exist. add other country or remove " + countryThree + ".");
        } else if (countryFourGDP.isEmpty() && countryFour != null) {
            throw new IllegalStateException("country: " + countryFour + " does not exist. add other country or remove " + countryFour + ".");
        }

        List<GDP> countryAllGDPData = new ArrayList<>();
        countryAllGDPData.addAll(countryOneGDP);
        countryAllGDPData.addAll(countryTwoGDP);
        countryAllGDPData.addAll(countryThreeGDP);
        countryAllGDPData.addAll(countryFourGDP);

        return countryAllGDPData;
    }

    // getGDPDataByManyCountriesInAYear() --->> put year and 4 countries

}
