package org.pgs.postp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Invoices")
public class InvoiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceID")
    private Long invoiceID;

    @ManyToOne
    @JoinColumn(name = "SupplierID", nullable = false)
    private SupplierModel supplier;

    @Column(name = "TotalAmount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "DueDate")
    private LocalDate dueDate;

    @Column(name = "Status", nullable = false)
    private String status;

    // Constructors
    public InvoiceModel() {
    }

    public InvoiceModel(SupplierModel supplier, BigDecimal totalAmount, LocalDate dueDate, String status) {
        this.supplier = supplier;
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

    public SupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
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
