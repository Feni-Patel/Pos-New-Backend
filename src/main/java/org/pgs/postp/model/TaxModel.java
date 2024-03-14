package org.pgs.postp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tax")
public class TaxModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaxID")
    private Long taxID;

    @Column(name = "TaxName", nullable = false)
    private String taxName;

    @Column(name = "TaxRate", nullable = false)
    private double taxRate;

    // Constructors
    public TaxModel() {
    }

    public TaxModel(String taxName, double taxRate) {
        this.taxName = taxName;
        this.taxRate = taxRate;
    }

    // Getters and Setters
    public Long getTaxID() {
        return taxID;
    }

    public void setTaxID(Long taxID) {
        this.taxID = taxID;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
