package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentPopulationRepository extends JpaRepository<CurrentPopulation, Long> {

//    Optional<CurrentPopulation> getCurrentPopulationByCountryOrCountryId(String country, Long countryId);
//
//    Optional<CurrentPopulation> findByCountry(String country);

}
