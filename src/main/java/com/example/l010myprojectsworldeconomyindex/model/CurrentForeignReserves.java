package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "current_foreign_reserves_tbl")
public class CurrentForeignReserves {

    @Id
    @SequenceGenerator(
            name = "current_foreign_reserves_sequence",
            sequenceName = "current_foreign_reserves_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "current_foreign_reserves_sequence"
    )
    private Long currentForeignReservesId;
    private Integer currentForeignReservesValue;
    private Year year;
    private Month month;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "foreign_reserves_id",
            referencedColumnName = "foreignReservesId"
    )
    private ForeignReserves foreignReserves;

    @OneToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "countryId"
    )
    private Country country;

    public CurrentForeignReserves() {
    }

    public CurrentForeignReserves(Integer currentForeignReservesValue, Year year, Month month, ForeignReserves foreignReserves, Country country) {
        this.currentForeignReservesValue = currentForeignReservesValue;
        this.year = year;
        this.month = month;
        this.foreignReserves = foreignReserves;
        this.country = country;
    }

    public Long getCurrentForeignReservesId() {
        return currentForeignReservesId;
    }

    public void setCurrentForeignReservesId(Long currentForeignReservesId) {
        this.currentForeignReservesId = currentForeignReservesId;
    }

    public Integer getCurrentForeignReservesValue() {
        return currentForeignReservesValue;
    }

    public void setCurrentForeignReservesValue(Integer currentForeignReservesValue) {
        this.currentForeignReservesValue = currentForeignReservesValue;
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

    public ForeignReserves getForeignReserves() {
        return foreignReserves;
    }

    public void setForeignReserves(ForeignReserves foreignReserves) {
        this.foreignReserves = foreignReserves;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
