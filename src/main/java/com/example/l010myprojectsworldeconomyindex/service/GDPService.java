package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.repository.GDPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.YearMonth;
import java.util.List;

@Service
public class GDPService {

    private final GDPRepository gdpRepository;

    @Autowired
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
}
