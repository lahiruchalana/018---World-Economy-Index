package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;

@Entity
@Table(name = "country_tbl")
public class Country {

    @Id
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )
    private Long countryId;
    private String countryName;
    private String continentName;
    private String subContinentName;

    public Country() {

    }

    public Country(Long countryId, String countryName, String continentName, String subContinentName) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.continentName = continentName;
        this.subContinentName = subContinentName;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getSubContinentName() {
        return subContinentName;
    }

    public void setSubContinentName(String subContinentName) {
        this.subContinentName = subContinentName;
    }
}
