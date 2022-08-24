package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.List;

@Repository
public interface GDPRepository extends JpaRepository<GDP, Long> {

    // get all the records of a country
    List<GDP> findAllByCountry(String country);

    // get records of relevant time period
    List<GDP> findAllByCountryAndYearAfterAndYearBefore(String country, YearMonth yearStart, YearMonth yearEnd);


}
