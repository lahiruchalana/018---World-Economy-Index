package com.example.l010myprojectsworldeconomyindex.repository;

import com.example.l010myprojectsworldeconomyindex.model.CurrencyRate;
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
    // can not have List of CurrencyRate -> because only one CurrencyRate should have for relevant currencyName, equalsCurrencyName and "current" recordStatus
    // if there is a two or many current recordStatus for a currencyName and equalsCurrencyName -> then pls delete those (only one can exist)

    List<CurrencyRate> getCurrencyRatesByRecordStatus(String recordStatus);

    List<CurrencyRate> getCurrencyRatesByCurrencyCurrencyNameAndEqualsCurrencyCurrencyName(String currencyName, String equalsCurrencyName);

    Optional<CurrencyRate> getCurrencyRatesByYearAndMonthAndDateAndCurrencyCurrencyIdAndEqualsCurrencyCurrencyId(Year year, Month month, Integer date, Long currencyId, Long equalsCurrencyId);
}
