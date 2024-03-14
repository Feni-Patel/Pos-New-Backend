package org.pgs.postp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "InvoiceReturns")
public class InvoiceReturnModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReturnID")
    private Long returnID;

    @ManyToOne
    @JoinColumn(name = "InvoiceID", nullable = false)
    private InvoiceModel invoice;

    @Column(name = "ReturnDate", nullable = false)
    private LocalDateTime returnDate;

    @Column(name = "ReturnReason")
    private String returnReason;

    @Column(name = "RefundAmount", nullable = false)
    private BigDecimal refundAmount;

    // Constructors
    public InvoiceReturnModel() {
    }

    public InvoiceReturnModel(InvoiceModel invoice, LocalDateTime returnDate, String returnReason, BigDecimal refundAmount) {
        this.invoice = invoice;
        this.returnDate = returnDate;
        this.returnReason = returnReason;
        this.refundAmount = refundAmount;
    }

    // Getters and Setters
    public Long getReturnID() {
        return returnID;
    }

    public void setReturnID(Long returnID) {
        this.returnID = returnID;
    }

    public InvoiceModel getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceModel invoice) {
        this.invoice = invoice;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }
}
