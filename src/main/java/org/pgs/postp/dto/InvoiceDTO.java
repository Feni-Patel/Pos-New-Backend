package org.pgs.postp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceDTO {
    private Long invoiceID;
    private Long supplierId;
    private BigDecimal totalAmount;
    private LocalDate dueDate;
    private String status;

    // Constructors
    public InvoiceDTO() {
    }

    public InvoiceDTO(Long invoiceID, Long supplierId, BigDecimal totalAmount, LocalDate dueDate, String status) {
        this.invoiceID = invoiceID;
        this.supplierId = supplierId;
        this.totalAmount = totalAmount;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Long invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
