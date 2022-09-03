package com.example.l010myprojectsworldeconomyindex.model;

import javax.persistence.*;

@Entity
@Table(name = "currency_rate_tbl")
public class CurrencyRate {

    @Id
    @SequenceGenerator(
            name = "currency_rate_sequence",
            sequenceName = "currency_rate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "currency_rate_sequence"
    )
    private Long currencyRateId;
    private Float currencyRateValue;
    private String recordStatus;    // past or current

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "currency_id",
            referencedColumnName = "currencyId"
    )
    private Currency currency;          // equalsCurrency value 1 equals to XXX currency value

    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "equals_currency_id",
            referencedColumnName = "currencyId"
    )
    private Currency equalsCurrency;            // equalsCurrency value 1 equals to XXX currency value

    public CurrencyRate() {
    }

    public CurrencyRate(Float currencyRateValue, String recordStatus, Currency currency, Currency equalsCurrency) {
        this.currencyRateValue = currencyRateValue;
        this.recordStatus = recordStatus;
        this.currency = currency;
        this.equalsCurrency = equalsCurrency;
    }

    public Long getCurrencyRateId() {
        return currencyRateId;
    }

    public void setCurrencyRateId(Long currencyRateId) {
        this.currencyRateId = currencyRateId;
    }

    public Float getCurrencyRateValue() {
        return currencyRateValue;
    }

    public void setCurrencyRateValue(Float currencyRateValue) {
        this.currencyRateValue = currencyRateValue;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getEqualsCurrency() {
        return equalsCurrency;
    }

    public void setEqualsCurrency(Currency equalsCurrency) {
        this.equalsCurrency = equalsCurrency;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "currencyRateId=" + currencyRateId +
                ", currencyRateValue=" + currencyRateValue +
                ", recordStatus='" + recordStatus + '\'' +
                ", currency=" + currency +
                ", equalsCurrency=" + equalsCurrency +
                '}';
    }
}
