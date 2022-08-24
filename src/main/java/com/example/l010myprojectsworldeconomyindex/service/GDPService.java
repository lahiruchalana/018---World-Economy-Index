package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.repository.GDPRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class GDPService {

    private final GDPRepository gdpRepository;

    public GDPService(GDPRepository gdpRepository) {
        this.gdpRepository = gdpRepository;
    }

    public void addNewGDPData(GDP gdp) {
        gdpRepository.save(gdp);
    }

    public List<GDP> getAllGDPData() {
        return gdpRepository.findAll();
    }
//
//    @Transactional
//    public void updateGDPData(Long gdpId, Integer gdpValue, YearMonth year) {
//        GDP gdp = gdpRepository.findById(gdpId).orElseThrow(() -> new IllegalStateException(
//                "gdpId:" + gdpId + " does not exist"
//        ));
//
//        if (gdpValue != null && gdpValue > 0) {
//            gdp.setGdpValue(gdpValue);
//        }
//
//        if (year != null) {
//            gdp.setYear(year);
//        }
//
//    }
//
//    public List<GDP> getGDPByCountry(String country) {
//        List<GDP> gdpList = gdpRepository.findAllByCountry(country);
//
//        if (gdpList.isEmpty()) {
//            throw new IllegalStateException("country: " + country + " does not exist");
//        }
//
//        return gdpList;
//    }
//
//
//    public void deleteGDPData(Long gdpId) {
//        GDP gdp = gdpRepository.findById(gdpId).orElseThrow(() -> new IllegalStateException(
//                "id: " + gdpId + " does not exist"
//        ));
//
//        System.out.println(gdpId);
//        gdpRepository.delete(gdp);
//    }
//
//    public List<GDP> getGDPDataByCountryAndYearBetween(String country, YearMonth yearMonthStart, YearMonth yearMonthEnd) {
//        List<GDP> gdpList = gdpRepository.findAllByCountryAndYearAfterAndYearBefore(country, yearMonthStart, yearMonthEnd);
//
//        if (gdpList.isEmpty()) {
//            throw new IllegalStateException("country: " + country + " has no any recorded GDP data between " + yearMonthStart + " - " + yearMonthEnd + " time period");
//        }
//
//        return gdpList;
//    }
//
//
//    public List<GDP> getGDPDataByManyCountries(String countryOne, String countryTwo, String countryThree, String countryFour) {
//        List<GDP> countryOneGDP = gdpRepository.findAllByCountry(countryOne);
//        List<GDP> countryTwoGDP = gdpRepository.findAllByCountry(countryTwo);
//        List<GDP> countryThreeGDP = gdpRepository.findAllByCountry(countryThree);
//        List<GDP> countryFourGDP = gdpRepository.findAllByCountry(countryFour);
//
//        if (countryOneGDP.isEmpty() && countryOne != null) {
//            throw new IllegalStateException("country: " + countryOne + " does not exist. add other country or remove " + countryOne + ".");
//        } else if (countryTwoGDP.isEmpty() && countryTwo != null) {
//            throw new IllegalStateException("country: " + countryTwo + " does not exist. add other country or remove " + countryTwo + ".");
//        } else if (countryThreeGDP.isEmpty() && countryThree != null) {
//            throw new IllegalStateException("country: " + countryThree + " does not exist. add other country or remove " + countryThree + ".");
//        } else if (countryFourGDP.isEmpty() && countryFour != null) {
//            throw new IllegalStateException("country: " + countryFour + " does not exist. add other country or remove " + countryFour + ".");
//        }
//
//        List<GDP> countryAllGDPData = new ArrayList<>();
//        countryAllGDPData.addAll(countryOneGDP);
//        countryAllGDPData.addAll(countryTwoGDP);
//        countryAllGDPData.addAll(countryThreeGDP);
//        countryAllGDPData.addAll(countryFourGDP);
//
//        return countryAllGDPData;
//    }
}
