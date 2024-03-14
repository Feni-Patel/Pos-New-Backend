package org.pgs.postp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TransactionDetails")
public class TransactionDetailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionDetailID")
    private Long transactionDetailID;

    @ManyToOne
    @JoinColumn(name = "TransactionID", nullable = false)
    private TransactionModel transaction;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private ProductModel product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "UnitPrice", nullable = false)
    private double unitPrice;

    @Column(name = "Discount", nullable = false)
    private double discount;

    // Constructors
    public TransactionDetailModel() {
    }

    public TransactionDetailModel(TransactionModel transaction, ProductModel product, int quantity, double unitPrice, double discount) {
        this.transaction = transaction;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    // Getters and Setters
    public Long getTransactionDetailID() {
        return transactionDetailID;
    }

    public void setTransactionDetailID(Long transactionDetailID) {
        this.transactionDetailID = transactionDetailID;
    }

    public TransactionModel getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionModel transaction) {
        this.transaction = transaction;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
