//package com.example.l010myprojectsworldeconomyindex.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.time.Year;
//
//@Entity
//@Table
//public class CurrentPopulation {
//
//    @Id
//    @GeneratedValue
//    private Long currentPopulationId;
//    private Long countryId;
//    private String country;
//    private Integer currentPopulation;
//    private Year updatedYear;
//
//    public CurrentPopulation() {
//    }
//
//    public CurrentPopulation(Long countryId, String country, Integer currentPopulation, Year updatedYear) {
//        this.countryId = countryId;
//        this.country = country;
//        this.currentPopulation = currentPopulation;
//        this.updatedYear = updatedYear;
//    }
//
//    public CurrentPopulation(Long currentPopulationId, Long countryId, String country, Integer currentPopulation, Year updatedYear) {
//        this.currentPopulationId = currentPopulationId;
//        this.countryId = countryId;
//        this.country = country;
//        this.currentPopulation = currentPopulation;
//        this.updatedYear = updatedYear;
//    }
//
//    public Long getCurrentPopulationId() {
//        return currentPopulationId;
//    }
//
//    public void setCurrentPopulationId(Long currentPopulationId) {
//        this.currentPopulationId = currentPopulationId;
//    }
//
//    public Long getCountryId() {
//        return countryId;
//    }
//
//    public void setCountryId(Long countryId) {
//        this.countryId = countryId;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public Integer getCurrentPopulation() {
//        return currentPopulation;
//    }
//
//    public void setCurrentPopulation(Integer currentPopulation) {
//        this.currentPopulation = currentPopulation;
//    }
//
//    public Year getUpdatedYear() {
//        return updatedYear;
//    }
//
//    public void setUpdatedYear(Year updatedYear) {
//        this.updatedYear = updatedYear;
//    }
//
//    @Override
//    public String toString() {
//        return "CurrentPopulation{" +
//                "currentPopulationId=" + currentPopulationId +
//                ", countryId=" + countryId +
//                ", country='" + country + '\'' +
//                ", currentPopulation=" + currentPopulation +
//                ", updatedYear=" + updatedYear +
//                '}';
//    }
//}
