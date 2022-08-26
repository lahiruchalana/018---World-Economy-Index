package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "gdp_tbl")
public class GDP {

    @Id
    @SequenceGenerator(
            name = "gdp_sequence",
            sequenceName = "gdp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gdp_sequence"
    )
    private Long gdpId;
    private Integer gdpValue;
    private Year year;
    private Month month;

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "countryId"
    )
    private Country country;

    public GDP() {
    }

    public GDP(Long gdpId, Integer gdpValue, Year year, Month month, Country country) {
        this.gdpId = gdpId;
        this.gdpValue = gdpValue;
        this.year = year;
        this.month = month;
        this.country = country;
    }

    public Long getGdpId() {
        return gdpId;
    }

    public void setGdpId(Long dgpId) {
        this.gdpId = dgpId;
    }

    public Integer getGdpValue() {
        return gdpValue;
    }

    public void setGdpValue(Integer gdpValue) {
        this.gdpValue = gdpValue;
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
