package org.pgs.postp.dto;

public class TaxDTO {
    private Long taxID;
    private String taxName;
    private double taxRate;

    // Constructors
    public TaxDTO() {
    }

    public TaxDTO(Long taxID, String taxName, double taxRate) {
        this.taxID = taxID;
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
