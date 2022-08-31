package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.ForeignReserves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignReservesRepository extends JpaRepository<ForeignReserves, Long> {


}
