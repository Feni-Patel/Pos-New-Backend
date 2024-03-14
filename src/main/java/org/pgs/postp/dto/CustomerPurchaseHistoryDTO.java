package org.pgs.postp.dto;

import java.time.LocalDateTime;

public class CustomerPurchaseHistoryDTO {
    private Long purchaseID;
    private Long customerId;
    private Long transactionId;
    private LocalDateTime purchaseDate;

    // Constructors
    public CustomerPurchaseHistoryDTO() {
    }

    public CustomerPurchaseHistoryDTO(Long purchaseID, Long customerId, Long transactionId, LocalDateTime purchaseDate) {
        this.purchaseID = purchaseID;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.purchaseDate = purchaseDate;
    }

    // Getters and Setters
    public Long getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Long purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
