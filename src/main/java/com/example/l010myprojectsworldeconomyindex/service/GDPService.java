package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.repository.GDPRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.YearMonth;
import java.util.List;

@Service
public class GDPService {

    private final GDPRepository gdpRepository;


    public GDPService(GDPRepository gdpRepository) {
        this.gdpRepository = gdpRepository;
    }

    public void addNewGDP(GDP gdp) {
        gdpRepository.save(gdp);
    }

    public List<GDP> getGDPData() {
        return gdpRepository.findAll();
    }

    @Transactional
    public void updateGDPData(Long gdpId, Integer gdpValue, YearMonth year) {
        GDP gdp = gdpRepository.findById(gdpId).orElseThrow(() -> new IllegalStateException(
                "gdpId:" + gdpId + " does not exist"
        ));

        if (gdpValue != null && gdpValue > 0) {
            gdp.setGdpValue(gdpValue);
        }

        if (year != null) {
            gdp.setYear(year);
        }

    }

    public List<GDP> getGDPByCountry(String country) {
        List<GDP> gdpList = gdpRepository.findAllByCountry(country);

        if (gdpList.isEmpty()) {
            throw new IllegalStateException("country: " + country + " does not exist");
        }

        return gdpList;
    }


    public void deleteGDPData(Long gdpId) {
        GDP gdp = gdpRepository.findById(gdpId).orElseThrow(() -> new IllegalStateException(
                "id: " + gdpId + " does not exist"
        ));

        System.out.println(gdpId);
        gdpRepository.delete(gdp);
    }

    public List<GDP> getGDPDataByCountryAndYearBetween(String country, YearMonth yearMonthStart, YearMonth yearMonthEnd) {
        List<GDP> gdpList = gdpRepository.findAllByCountryAndYearAfterAndYearBefore(country, yearMonthStart, yearMonthEnd);

        if (gdpList.isEmpty()) {
            throw new IllegalStateException("country: " + country + " has no any recorded GDP data between " + yearMonthStart + " - " + yearMonthEnd + " time period");
        }

        return gdpList;
    }
}
