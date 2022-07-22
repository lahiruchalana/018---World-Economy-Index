package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Country {
    @Id
    private Long countryId;
    private String country;
    private Long continentId;
    private String continent;
    private Long subContinentId;
    private String subContinent;

    public Country() {

    }

    public Country(Long countryId, String country, Long continentId, String continent, Long subContinentId, String subContinent) {
        this.countryId = countryId;
        this.country = country;
        this.continentId = continentId;
        this.continent = continent;
        this.subContinentId = subContinentId;
        this.subContinent = subContinent;
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

    public Long getContinentId() {
        return continentId;
    }

    public void setContinentId(Long continentId) {
        this.continentId = continentId;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Long getSubContinentId() {
        return subContinentId;
    }

    public void setSubContinentId(Long subContinentId) {
        this.subContinentId = subContinentId;
    }

    public String getSubContinent() {
        return subContinent;
    }

    public void setSubContinent(String subContinent) {
        this.subContinent = subContinent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", country='" + country + '\'' +
                ", continentId=" + continentId +
                ", continent='" + continent + '\'' +
                ", subContinentId=" + subContinentId +
                ", subContinent='" + subContinent + '\'' +
                '}';
    }
}
