package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentGDP;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentGDPRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrentGDPService {

    private final CurrentGDPRepository currentGDPRepository;

    public CurrentGDPService(CurrentGDPRepository currentGDPRepository) {
        this.currentGDPRepository = currentGDPRepository;
    }

    public void addNewCurrentGDPData(CurrentGDP currentGDP) {
        Optional<CurrentGDP> currentGDPOptional = currentGDPRepository.findCurrentGDPByCountryName(currentGDP.getCountry().getCountryName());

        if (currentGDPOptional.isPresent()) {       // already happening // passing an exception by spring boot -->> for OneToOne relationship with country(can not duplicate country ID)
            throw new IllegalStateException("country" + currentGDP.getCountry().getCountryName() + " already exist in the database, so update the existing country data");
        }

        currentGDPRepository.save(currentGDP);

    }

    public List<CurrentGDP> getAllCurrentGDPData() {
        return currentGDPRepository.findAll();
    }

    public void deleteCurrentGDPData(Long currentGdpId) {
        CurrentGDP currentGDP = currentGDPRepository.findById(currentGdpId).orElseThrow(() ->
                new IllegalStateException("currentGdpId : " + currentGdpId + " does not exist")
        );

        currentGDPRepository.delete(currentGDP);
    }
}
