package org.pgs.postp.dto;

import java.math.BigDecimal;

public class TransactionDetailDTO {
    private Long transactionDetailID;
    private Long transactionID;
    private Long productID;
    private BigDecimal quantity;
    private double unitPrice;
    private double discount;

    public Long getTransactionDetailID() {
        return transactionDetailID;
    }

    public void setTransactionDetailID(Long transactionDetailID) {
        this.transactionDetailID = transactionDetailID;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
