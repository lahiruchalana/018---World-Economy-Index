package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

    @Query("select s from CurrencyRate s where s.currency.currencyName = ?1 and s.equalsCurrency.currencyName = ?2 and s.recordStatus = ?3")
    Optional<CurrencyRate> getCurrencyRateByCurrencyAndEqualsCurrencyAndRecordStatus(String currencyName, String equalsCurrencyName, String recordStatus);

    List<CurrencyRate> findAllByOrderByYearAscMonthAscDateAsc();

    Page<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName(String currencyName, String equalsCurrencyName, Pageable pageable);

    List<CurrencyRate> getCurrencyRatesByRecordStatus(String recordStatus);

    List<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByYearAscMonthAscDateAsc(String currencyName, String equalsCurrencyName);

    List<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByYearDescMonthDescDateDesc(String currencyName, String equalsCurrencyName);

    List<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateValueAsc(String currencyName, String equalsCurrencyName);

    List<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateValueDesc(String currencyName, String equalsCurrencyName);

    List<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateIdAsc(String currencyName, String equalsCurrencyName);

    List<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateIdDesc(String currencyName, String equalsCurrencyName);

    Optional<CurrencyRate> getCurrencyRatesByYearAndMonthAndDateAndCurrencyCurrencyIdAndEqualsCurrencyCurrencyId(Year year, Month month, Integer date, Long currencyId, Long equalsCurrencyId);

    Page<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByYearAscMonthAscDateAsc(String currencyName, String equalsCurrencyName, Pageable pageable);

    Page<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByYearDescMonthDescDateDesc(String currencyName, String equalsCurrencyName, Pageable pageable);

    Page<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateValueAsc(String currencyName, String equalsCurrencyName, Pageable pageable);

    Page<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateValueDesc(String currencyName, String equalsCurrencyName, Pageable pageable);

    Page<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateIdAsc(String currencyName, String equalsCurrencyName, Pageable pageable);

    Page<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyNameOrderByCurrencyRateIdDesc(String currencyName, String equalsCurrencyName, Pageable pageable);

}
