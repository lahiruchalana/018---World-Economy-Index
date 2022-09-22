package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.CurrentGDP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentGDPRepository extends JpaRepository<CurrentGDP, Long> {

    @Query("select g from CurrentGDP g where g.country.countryName = ?1")
    Optional<CurrentGDP> findCurrentGDPByCountryName(String countryName);

}
