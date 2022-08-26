package com.example.l010myprojectsworldeconomyindex.service;

import com.example.l010myprojectsworldeconomyindex.model.CurrentGDP;
import com.example.l010myprojectsworldeconomyindex.model.GDP;
import com.example.l010myprojectsworldeconomyindex.repository.CurrentGDPRepository;
import com.example.l010myprojectsworldeconomyindex.repository.GDPRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class CurrentGDPService {

    private final CurrentGDPRepository currentGDPRepository;

    private final GDPRepository gdpRepository;

    public CurrentGDPService(CurrentGDPRepository currentGDPRepository, GDPRepository gdpRepository) {
        this.currentGDPRepository = currentGDPRepository;
        this.gdpRepository = gdpRepository;
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

    public void deleteCurrentGDPData(Long currentGdpId, Boolean isDeletingGdpValueInGDPTable) {
        CurrentGDP currentGDP = currentGDPRepository.findById(currentGdpId).orElseThrow(() ->
                new IllegalStateException("currentGdpId : " + currentGdpId + " does not exist")
        );

        if (isDeletingGdpValueInGDPTable) {
            currentGDPRepository.delete(currentGDP);
        } else {
            GDP gdp = new GDP(currentGDP.getCurrentGDPValue(), currentGDP.getYear(), currentGDP.getMonth(), currentGDP.getCountry());

            gdpRepository.save(gdp);        // saved past currentGdpValue in GDP Table

            currentGDPRepository.delete(currentGDP);
        }
    }

    @Transactional
    public void updateCurrentGDPData(String countryName, Boolean isPastGDPDataSavingInGDPTableAsAGDPData, Integer currentGDPValue, Year year, Month month) {
        Optional<CurrentGDP> currentGDPOptional = currentGDPRepository.findCurrentGDPByCountryName(countryName);

        if(!currentGDPOptional.isPresent()) {
            throw new IllegalStateException("country : " + countryName + " does not exists");
        }

        if (isPastGDPDataSavingInGDPTableAsAGDPData) {
            GDP gdp = new GDP(currentGDPOptional.get().getCurrentGDPValue(), currentGDPOptional.get().getYear(), currentGDPOptional.get().getMonth(), currentGDPOptional.get().getCountry());

            gdpRepository.save(gdp);
        }

        // update currentGDP data
        currentGDPOptional.get().setCurrentGDPValue(currentGDPValue);
        currentGDPOptional.get().setYear(year);
        currentGDPOptional.get().setMonth(month);

        // update GDP data
        currentGDPOptional.get().getGdp().setGdpValue(currentGDPValue);
        currentGDPOptional.get().getGdp().setYear(year);
        currentGDPOptional.get().getGdp().setMonth(month);
    }

    public Optional<CurrentGDP> getCurrentGDPDataByCountryName(String countryName) {
        return currentGDPRepository.findCurrentGDPByCountryName(countryName);
    }
}
