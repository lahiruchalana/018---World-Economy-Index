package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.GDP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GDPRepository extends JpaRepository<GDP, Long> {

    @Query("SELECT g FROM GDP g WHERE g.country = ?1")
    Optional<GDP> findByCountry(String country);
}
