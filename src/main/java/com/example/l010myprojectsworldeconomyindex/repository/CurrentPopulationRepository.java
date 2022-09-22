package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.CurrentPopulation;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentPopulationRepository extends JpaRepository<CurrentPopulation, Long> {

    @Query("select cp from CurrentPopulation cp where cp.country.countryName = ?1")
    Optional<CurrentPopulation> findCurrentPopulationByCountryName(String countryName);

}
