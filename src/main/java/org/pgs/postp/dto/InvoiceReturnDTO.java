package org.pgs.postp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceReturnDTO {
    private Long returnID;
    private Long invoiceId;
    private LocalDateTime returnDate;
    private String returnReason;
    private BigDecimal refundAmount;

    // Constructors
    public InvoiceReturnDTO() {
    }

    public InvoiceReturnDTO(Long returnID, Long invoiceId, LocalDateTime returnDate, String returnReason, BigDecimal refundAmount) {
        this.returnID = returnID;
        this.invoiceId = invoiceId;
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

    public Long getInvoiceID() {
        return invoiceId;
    }

    public void setInvoiceID(Long invoiceId) {
        this.invoiceId = invoiceId;
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
