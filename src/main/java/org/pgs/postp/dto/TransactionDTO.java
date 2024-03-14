package org.pgs.postp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    private Long transactionID;
    private Long userID;
    private Long customerID;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private LocalDateTime transactionDate;

    // Constructors
    public TransactionDTO() {
    }

    public TransactionDTO(Long transactionID, Long userID, Long customerID, BigDecimal totalAmount, String paymentMethod, LocalDateTime transactionDate) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.customerID = customerID;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
