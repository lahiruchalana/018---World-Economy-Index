package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "economy_growth_rate_tbl")
public class EconomyGrowthRate {

    @Id
    @SequenceGenerator(
            name = "economy_growth_rate_sequence",
            sequenceName = "economy_growth_rate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "economy_growth_rate_sequence"
    )
    private Long economyGrowthRateId;
    private Float economyGrowthRateValue;
    private Year year;
    private Month month;

    @OneToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "countryId"
    )
    private Country country;

    public EconomyGrowthRate() {
    }

    public EconomyGrowthRate(Float economyGrowthRateValue, Year year, Month month, Country country) {
        this.economyGrowthRateValue = economyGrowthRateValue;
        this.year = year;
        this.month = month;
        this.country = country;
    }

    public Long getEconomyGrowthRateId() {
        return economyGrowthRateId;
    }

    public void setEconomyGrowthRateId(Long economyGrowthRateId) {
        this.economyGrowthRateId = economyGrowthRateId;
    }

    public Float getEconomyGrowthRateValue() {
        return economyGrowthRateValue;
    }

    public void setEconomyGrowthRateValue(Float economyGrowthRateValue) {
        this.economyGrowthRateValue = economyGrowthRateValue;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
