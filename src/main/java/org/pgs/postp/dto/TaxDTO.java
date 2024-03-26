package org.pgs.postp.dto;

import java.math.BigDecimal;

public class TaxDTO {
    private Long taxID;
    private String taxName;
    private BigDecimal taxRate;

    // Constructors
    public TaxDTO() {
    }

    public TaxDTO(Long taxID, String taxName, BigDecimal taxRate) {
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

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
