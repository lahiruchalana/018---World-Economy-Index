package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import com.example.l010myprojectsworldeconomyindex.model.Population;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentPopulationRepository;
import com.example.l010myprojectsworldeconomyindex.repository.PopulationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class CurrentPopulationService {

    private final CurrentPopulationRepository currentPopulationRepository;

    private final PopulationRepository populationRepository;

    public CurrentPopulationService(CurrentPopulationRepository currentPopulationRepository, PopulationRepository populationRepository) {
        this.currentPopulationRepository = currentPopulationRepository;
        this.populationRepository = populationRepository;
    }

    public void addNewCurrentPopulationData(CurrentPopulation currentPopulation) {


        // create a population data to store table


        currentPopulationRepository.save(currentPopulation);
    }

    public List<CurrentPopulation> getALlCurrentPopulationData() {
        return currentPopulationRepository.findAll();
    }

    public Optional<CurrentPopulation> getCurrentPopulationDataByCountryName(String countryName) {
        Optional<CurrentPopulation> currentPopulationOptional = currentPopulationRepository.findCurrentPopulationByCountryName(countryName);

        if (!currentPopulationOptional.isPresent()) {
            throw new IllegalStateException("country: " + countryName + " does not exist");
        }

        return currentPopulationRepository.findCurrentPopulationByCountryName(countryName);
    }

    public void deleteCurrentPopulationData(Long currentPopulationId) {
        CurrentPopulation currentPopulation = currentPopulationRepository.findById(currentPopulationId).orElseThrow( () ->
                new IllegalStateException("currentPopulationId: " + currentPopulationId + " does not exist.")
        );

        currentPopulationRepository.delete(currentPopulation);
    }

    @Transactional
    public void updateCurrentPopulationData(String countryName, Integer currentPopulationValue, Float currentPopulationGrowth, Year year) throws IllegalStateException {
        Optional<CurrentPopulation> currentPopulationOptional = currentPopulationRepository.findCurrentPopulationByCountryName(countryName);

        if (!currentPopulationOptional.isPresent()) {
            throw new IllegalStateException("country: " + countryName + " doest not exist, so first create the country: " + countryName + " data");
        }

        Population population = new Population(currentPopulationValue, currentPopulationGrowth, year, currentPopulationOptional.get().getCountry());

        populationRepository.save(population);      // save a new population data when update the currentPopulationData

        currentPopulationOptional.get().setCurrentPopulationValue(currentPopulationValue);
        currentPopulationOptional.get().setCurrentPopulationGrowthRate(currentPopulationGrowth);
        currentPopulationOptional.get().setYear(year);
    }



//    public void addCurrentPopulationData(CurrentPopulation currentPopulation) {
//        Optional<CurrentPopulation> currentPopulationOptional =
//                currentPopulationRepository.getCurrentPopulationByCountryOrCountryId(currentPopulation.getCountry(), currentPopulation.getCountryId());
//
//        if (currentPopulationOptional.isPresent()) {
//            throw new IllegalStateException("country: " + currentPopulation.getCountry() + " or countryId: " + currentPopulation.getCountryId() +
//                    " is existing, not allowing to create multiple records for a country. so please update the existing country record. use updateCurrentPopulationData method");
//        }
//
//        currentPopulationRepository.save(currentPopulation);
//    }

}
