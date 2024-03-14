package org.pgs.postp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CustomerPurchaseHistory")
public class CustomerPurchaseHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PurchaseID")
    private Long purchaseID;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn(name = "TransactionID", nullable = false)
    private TransactionModel transaction;

    @Column(name = "PurchaseDate", nullable = false)
    private LocalDateTime purchaseDate;

    // Constructors
    public CustomerPurchaseHistoryModel() {
    }

    public CustomerPurchaseHistoryModel(CustomerModel customer, TransactionModel transaction, LocalDateTime purchaseDate) {
        this.customer = customer;
        this.transaction = transaction;
        this.purchaseDate = purchaseDate;
    }

    // Getters and Setters
    public Long getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Long purchaseID) {
        this.purchaseID = purchaseID;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public TransactionModel getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionModel transaction) {
        this.transaction = transaction;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
