package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentPopulationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrentPopulationService {

    private final CurrentPopulationRepository currentPopulationRepository;

    public CurrentPopulationService(CurrentPopulationRepository currentPopulationRepository) {
        this.currentPopulationRepository = currentPopulationRepository;
    }

    public void addNewCurrentPopulationData(CurrentPopulation currentPopulation) {
        currentPopulationRepository.save(currentPopulation);
    }

    public List<CurrentPopulation> getALlCurrentPopulationData() {
        return currentPopulationRepository.findAll();
    }

    public Optional<CurrentPopulation> getCurrentPopulationDataByCountryName(String countryName) {
        Optional<CurrentPopulation> currentPopulationOptional = currentPopulationRepository.getCurrentPopulationByCountryName(countryName);

        if (!currentPopulationOptional.isPresent()) {
            throw new IllegalStateException("country: " + countryName + " does not exist");
        }

        return currentPopulationRepository.getCurrentPopulationByCountryName(countryName);
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

//    public void deleteCurrentPopulationData(Long currentPopulationId) {
//        CurrentPopulation currentPopulation = currentPopulationRepository.findById(currentPopulationId).orElseThrow( () ->
//                new IllegalStateException("currentPopulationId: " + currentPopulationId + " does not exist.")
//        );
//
//        currentPopulationRepository.delete(currentPopulation);
//    }
//
//    @Transactional
//    public void updateCurrentPopulationData(String country, Integer currentPopulation, Year updatedYear) throws IllegalStateException {
//        Optional<CurrentPopulation> currentPopulationOptional = currentPopulationRepository.findByCountry(country);
//
//        if (!currentPopulationOptional.isPresent()) {
//            throw new IllegalStateException("country: " + country + " doest not exist, so first create the country: " + country + " data");
//        }
//
//        currentPopulationOptional.get().setCurrentPopulation(currentPopulation);
//        currentPopulationOptional.get().setUpdatedYear(updatedYear);
//    }
}
