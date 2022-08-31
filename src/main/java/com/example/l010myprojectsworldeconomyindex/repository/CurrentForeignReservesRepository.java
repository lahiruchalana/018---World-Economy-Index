package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.CurrentForeignReserves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentForeignReservesRepository extends JpaRepository<CurrentForeignReserves, Long> {

}
