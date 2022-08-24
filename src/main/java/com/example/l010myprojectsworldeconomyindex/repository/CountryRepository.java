package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByCountryNameOrCountryId(String countryName, Long countryId);

    List<Country> findCountriesByCountryNameContaining(String countryName);     // search countries

    Optional<Country> findCountryByCountryName(String countryName);             // get country data by passing name

    List<Country> findCountriesByContinentName(String continentName);           // get countries data in continent

    List<Country> findCountriesBySubContinentName(String subContinentName);     // get countries data in sub continent
}
