package org.pgs.postp.dto;

public class VoucherDTO {
    private Long voucherID;
    private String voucherType;
    private Integer voucherDuration;
    private Integer voucherCount;
    private Double discountAmount;

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
