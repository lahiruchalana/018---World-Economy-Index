package com.example.l010myprojectsworldeconomyindex.model;


import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "population_tbl")
public class Population {

    @Id
    @SequenceGenerator(
            name = "population_sequence",
            sequenceName = "population_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "population_sequence"
    )
    private Long populationId;
    private Integer populationValue;
    private Float populationGrowthRate;
    private Year year;

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "countryId"
    )
    private Country country;

    public Population() {
    }

    public Population(Long populationId, Integer populationValue, Float populationGrowthRate, Year year, Country country) {
        this.populationId = populationId;
        this.populationValue = populationValue;
        this.populationGrowthRate = populationGrowthRate;
        this.year = year;
        this.country = country;
    }

    public Long getPopulationId() {
        return populationId;
    }

    public void setPopulationId(Long populationId) {
        this.populationId = populationId;
    }

    public Integer getPopulationValue() {
        return populationValue;
    }

    public void setPopulationValue(Integer populationValue) {
        this.populationValue = populationValue;
    }

    public Float getPopulationGrowthRate() {
        return populationGrowthRate;
    }

    public void setPopulationGrowthRate(Float populationGrowthRate) {
        this.populationGrowthRate = populationGrowthRate;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
