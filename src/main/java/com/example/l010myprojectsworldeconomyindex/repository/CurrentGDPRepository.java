package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.CurrentGDP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentGDPRepository extends JpaRepository<CurrentGDP, Long> {

    @Query("SELECT g FROM CurrentGDP g WHERE g.country.countryName = ?1")
    public Optional<CurrentGDP> findCurrentGDPByCountryName(String countryName);

}
