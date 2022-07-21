package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.YearMonth;

@Entity
@Table
public class GDP {
    @Id
    @GeneratedValue
    private Long dgpId;
    private Integer gdpValue;
    private YearMonth year;
    private Long countryId;
    private String country;

    public GDP() {
    }

    public GDP(Integer gdpValue, YearMonth year, Long countryId, String country) {
        this.gdpValue = gdpValue;
        this.year = year;
        this.countryId = countryId;
        this.country = country;
    }

    public GDP(Long dgpId, Integer gdpValue, YearMonth year, Long countryId, String country) {
        this.dgpId = dgpId;
        this.gdpValue = gdpValue;
        this.year = year;
        this.countryId = countryId;
        this.country = country;
    }

    public Long getDgpId() {
        return dgpId;
    }

    public void setDgpId(Long dgpId) {
        this.dgpId = dgpId;
    }

    public Integer getGdpValue() {
        return gdpValue;
    }

    public void setGdpValue(Integer gdpValue) {
        this.gdpValue = gdpValue;
    }

    public YearMonth getYear() {
        return year;
    }

    public void setYear(YearMonth year) {
        this.year = year;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "GDP{" +
                "dgpId=" + dgpId +
                ", gdpValue=" + gdpValue +
                ", year=" + year +
                ", countryId=" + countryId +
                ", country='" + country + '\'' +
                '}';
    }


}
