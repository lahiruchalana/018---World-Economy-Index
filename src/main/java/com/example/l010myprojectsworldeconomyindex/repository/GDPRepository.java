package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GDPRepository extends JpaRepository<GDP, Long> {

    Optional<GDP> findByCountry(String country);
    List<GDP> findAllByCountry(String country);

    // create some queries // func name -->> (retrieveGDPData())
}
