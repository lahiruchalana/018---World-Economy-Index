package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "currency_tbl")
public class Currency {

    @Id
    @SequenceGenerator(
            name = "currency_sequence",
            sequenceName = "currency_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "currency_sequence"
    )
    private Long currencyId;
    private String currencyName;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "currency_country_tbl",
            joinColumns = @JoinColumn(
                    name = "currency_id",
                    referencedColumnName = "currencyId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "country_id",
                    referencedColumnName = "countryId"
            )
    )
    private List<Country> countryList;

    public Currency() {
    }

    public Currency(String currencyName, List<Country> countryList) {
        this.currencyName = currencyName;
        this.countryList = countryList;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
