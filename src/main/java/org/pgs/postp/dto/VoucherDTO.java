package org.pgs.postp.dto;

import java.util.Date;

public class VoucherDTO {

    private Long voucherID;
    private String voucherCode;
    private Double discountAmount;
    private Integer validForNumberOfCustomers;
    private Integer validForNumberOfDays;
//    private Date validUntil;

    // Constructors
    public VoucherDTO() {
    }

    public VoucherDTO(Long voucherID, String voucherCode, Double discountAmount, Integer validForNumberOfCustomers, Integer validForNumberOfDays) {
        this.voucherID = voucherID;
        this.voucherCode = voucherCode;
        this.discountAmount = discountAmount;
        this.validForNumberOfCustomers = validForNumberOfCustomers;
        this.validForNumberOfDays = validForNumberOfDays;
//        this.validUntil = validUntil;
    }

    // Getters and Setters
    public Long getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(Long voucherID) {
        this.voucherID = voucherID;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getValidForNumberOfCustomers() {
        return validForNumberOfCustomers;
    }

    public void setValidForNumberOfCustomers(Integer validForNumberOfCustomers) {
        this.validForNumberOfCustomers = validForNumberOfCustomers;
    }

    public Integer getValidForNumberOfDays() {
        return validForNumberOfDays;
    }

    public void setValidForNumberOfDays(Integer validForNumberOfDays) {
        this.validForNumberOfDays = validForNumberOfDays;
    }

//    public Date getValidUntil() {
//        return validUntil;
//    }
//
//    public void setValidUntil(Date validUntil) {
//        this.validUntil = validUntil;
//    }
}
