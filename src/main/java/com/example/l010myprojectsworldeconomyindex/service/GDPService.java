package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.repository.GDPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
