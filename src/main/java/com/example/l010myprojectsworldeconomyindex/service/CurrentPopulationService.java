package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentPopulationRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrentPopulationService {

    private final CurrentPopulationRepository currentPopulationRepository;

    public CurrentPopulationService(CurrentPopulationRepository currentPopulationRepository) {
        this.currentPopulationRepository = currentPopulationRepository;
    }

    public void addCurrentPopulationData(CurrentPopulation currentPopulation) {

        currentPopulationRepository.save(currentPopulation);
    }
}
