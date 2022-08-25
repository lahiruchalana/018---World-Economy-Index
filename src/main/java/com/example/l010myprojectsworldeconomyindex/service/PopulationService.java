package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.Population;
import com.example.l010myprojectsworldeconomyindex.repository.PopulationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationService {

    private final PopulationRepository populationRepository;

    public PopulationService(PopulationRepository populationRepository) {
        this.populationRepository = populationRepository;
    }

    public void addNewPopulationData(Population population) {
        populationRepository.save(population);
    }

    public List<Population> getAllPopulationData() {
        return populationRepository.findAll();
    }

    public void deletePopulationData(Long populationId) {
        populationRepository.deleteById(populationId);
    }
}
