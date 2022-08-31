package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "foreign_reserves_tbl")
public class ForeignReserves {

    @Id
    @SequenceGenerator(
            name = "foreign_reserves_sequence",
            sequenceName = "foreign_reserves_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "foreign_reserves_sequence"
    )
    private Long foreignReservesId;
    private Integer foreignReservesValue;
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

    public ForeignReserves() {
    }

    public ForeignReserves(Integer foreignReservesValue, Year year, Month month, Country country) {
        this.foreignReservesValue = foreignReservesValue;
        this.year = year;
        this.month = month;
        this.country = country;
    }

    public Long getForeignReservesId() {
        return foreignReservesId;
    }

    public void setForeignReservesId(Long foreignReservesId) {
        this.foreignReservesId = foreignReservesId;
    }

    public Integer getForeignReservesValue() {
        return foreignReservesValue;
    }

    public void setForeignReservesValue(Integer foreignReservesValue) {
        this.foreignReservesValue = foreignReservesValue;
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
