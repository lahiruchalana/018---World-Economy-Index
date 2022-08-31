package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.CurrentForeignReserves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentForeignReservesRepository extends JpaRepository<CurrentForeignReserves, Long> {

    @Query("SELECT c from CurrentForeignReserves c where c.country.countryName = ?1")
    public Optional<CurrentForeignReserves> findCurrentForeignReservesByCountryName(String countryName);
}
