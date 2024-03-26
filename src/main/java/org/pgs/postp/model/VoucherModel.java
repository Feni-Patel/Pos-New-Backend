package org.pgs.postp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Vouchers")
public class VoucherModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VoucherID")
    private Long voucherID;

    @Column(name = "VoucherCode", nullable = false, unique = true)
    private String voucherCode;

    @Column(name = "DiscountAmount", nullable = false)
    private Double discountAmount;

    @Column(name = "ValidForNumberOfCustomers")
    private Integer validForNumberOfCustomers;

    @Column(name = "ValidForNumberOfDays")
    private Integer validForNumberOfDays;

//    @Temporal(TemporalType.DATE)
//    @Column(name = "ValidUntil")
//    private Date validUntil;

    // Constructors
    public VoucherModel() {
    }

    public VoucherModel(String voucherCode, Double discountAmount, Integer validForNumberOfCustomers, Integer validForNumberOfDays) {
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
