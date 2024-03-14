package org.pgs.postp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Transactions")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Long transactionID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private CustomerModel id;

    @Column(name = "TotalAmount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "TransactionDate", nullable = false)
    private LocalDateTime transactionDate;

    @OneToMany(mappedBy = "transaction")
    private List<TransactionDetailModel> transactionDetails;

    // Constructors
    public TransactionModel() {
    }

    public TransactionModel(UserModel user, CustomerModel id, BigDecimal totalAmount, String paymentMethod, LocalDateTime transactionDate) {
        this.user = user;
        this.id = id;
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public CustomerModel getId() {
        return id;
    }

    public void setId(CustomerModel id) {
        this.id = id;
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

    public List<TransactionDetailModel> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetailModel> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
