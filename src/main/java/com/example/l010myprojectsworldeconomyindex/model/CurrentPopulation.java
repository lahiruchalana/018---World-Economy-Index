package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "current_population_tbl")
public class CurrentPopulation {

    @Id
    @SequenceGenerator(
            name = "current_population_sequence",
            sequenceName = "current_population_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "current_population_sequence"
    )
    private Long currentPopulationId;
    private Integer currentPopulationValue;
    private Float currentPopulationGrowthRate;
    private Year year;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "population_id",
            referencedColumnName = "populationId"
    )
    private Population population;

    @OneToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "countryId"
    )
    private Country country;

    public CurrentPopulation() {
    }

    public CurrentPopulation(Long currentPopulationId, Integer currentPopulationValue, Float currentPopulationGrowthRate, Year year, Population population, Country country) {
        this.currentPopulationId = currentPopulationId;
        this.currentPopulationValue = currentPopulationValue;
        this.currentPopulationGrowthRate = currentPopulationGrowthRate;
        this.year = year;
        this.population = population;
        this.country = country;
    }

    public Long getCurrentPopulationId() {
        return currentPopulationId;
    }

    public void setCurrentPopulationId(Long currentPopulationId) {
        this.currentPopulationId = currentPopulationId;
    }

    public Integer getCurrentPopulationValue() {
        return currentPopulationValue;
    }

    public void setCurrentPopulationValue(Integer currentPopulationValue) {
        this.currentPopulationValue = currentPopulationValue;
    }

    public Float getCurrentPopulationGrowthRate() {
        return currentPopulationGrowthRate;
    }

    public void setCurrentPopulationGrowthRate(Float currentPopulationGrowthRate) {
        this.currentPopulationGrowthRate = currentPopulationGrowthRate;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
