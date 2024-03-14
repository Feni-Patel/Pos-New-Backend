package org.pgs.postp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Vouchers")
public class VoucherModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VoucherID")
    private Long voucherID;

    @Column(name = "VoucherType", nullable = false)
    private String voucherType;

    @Column(name = "VoucherDuration")
    private Integer voucherDuration;

    @Column(name = "VoucherCount")
    private Integer voucherCount;

    @Column(name = "DiscountAmount", nullable = false)
    private Double discountAmount;

    // Constructors
    public VoucherModel() {
    }

    public VoucherModel(String voucherType, Integer voucherDuration, Integer voucherCount, Double discountAmount) {
        this.voucherType = voucherType;
        this.voucherDuration = voucherDuration;
        this.voucherCount = voucherCount;
        this.discountAmount = discountAmount;
    }

    // Getters and Setters
    public Long getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(Long voucherID) {
        this.voucherID = voucherID;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public Integer getVoucherDuration() {
        return voucherDuration;
    }

    public void setVoucherDuration(Integer voucherDuration) {
        this.voucherDuration = voucherDuration;
    }

    public Integer getVoucherCount() {
        return voucherCount;
    }

    public void setVoucherCount(Integer voucherCount) {
        this.voucherCount = voucherCount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }
}
