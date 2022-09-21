package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;


@Repository
public interface GDPRepository extends JpaRepository<GDP, Long> {

    @Query("select g from GDP g where g.country.countryName = ?1")
    List<GDP> findGDPSByCountryName(String country);

    List<GDP> findGDPSByCountryCountryNameAndYear(String countryName, Year year);

}
