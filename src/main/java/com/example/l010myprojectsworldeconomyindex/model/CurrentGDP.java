package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "current_gdp_tbl")
public class CurrentGDP {

    @Id
    @SequenceGenerator(
            name = "current_gdp_sequence",
            sequenceName = "current_gdp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "current_gdp_sequence"
    )
    @Column(
            name = "current_gdp_id"
    )
    private Long currentGDPId;

    @Column(
            name = "current_gdp_value"
    )
    private Integer currentGDPValue;
    private Year year;
    private Month month;

    @OneToOne(
            optional = false,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "countryId"
    )
    private Country country;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "gdp_id",
            referencedColumnName = "gdpId"
    )
    private GDP gdp;

    public CurrentGDP() {
    }

    public CurrentGDP(Integer currentGDPValue, Year year, Month month, Country country, GDP gdp) {
        this.currentGDPValue = currentGDPValue;
        this.year = year;
        this.month = month;
        this.country = country;
        this.gdp = gdp;
    }

    public Long getCurrentGDPId() {
        return currentGDPId;
    }

    public void setCurrentGDPId(Long currentGDPId) {
        this.currentGDPId = currentGDPId;
    }

    public Integer getCurrentGDPValue() {
        return currentGDPValue;
    }

    public void setCurrentGDPValue(Integer currentGDPValue) {
        this.currentGDPValue = currentGDPValue;
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

    public GDP getGdp() {
        return gdp;
    }

    public void setGdp(GDP gdp) {
        this.gdp = gdp;
    }
}
