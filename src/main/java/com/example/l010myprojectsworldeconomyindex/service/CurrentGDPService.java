package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentGDP;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentGDPRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentGDPService {

    private final CurrentGDPRepository currentGDPRepository;

    public CurrentGDPService(CurrentGDPRepository currentGDPRepository) {
        this.currentGDPRepository = currentGDPRepository;
    }

    public void addNewCurrentGDPData(CurrentGDP currentGDP) {
        currentGDPRepository.save(currentGDP);
    }

    public List<CurrentGDP> getAllCurrentGDPData() {
        return currentGDPRepository.findAll();
    }
}
