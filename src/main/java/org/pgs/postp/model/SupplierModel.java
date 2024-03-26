package org.pgs.postp.model;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "Suppliers")
public class SupplierModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID")
    private Long supplierID;

    @Column(name = "SupplierAgency", nullable = false)
    private String supplierAgency;

    @Column(name = "ContactPerson")
    private String contactPerson;

    @Column(name = "SupplierEmail")
    private String supplierEmail;

    @Column(name = "SupplierPhone")
    private BigInteger supplierPhone;

    @Column(name = "ContactPersonEmail")
    private String contactPersonEmail;

    @Column(name = "ContactPersonPhone")
    private BigInteger contactPersonPhone;

    @Column(name = "Address")
    private String address;

    // Constructors
    public SupplierModel() {
    }

    public SupplierModel(String supplierAgency, String contactPerson, String supplierEmail, BigInteger supplierPhone,
                         String contactPersonEmail, BigInteger contactPersonPhone, String address) {
        this.supplierAgency = supplierAgency;
        this.contactPerson = contactPerson;
        this.supplierEmail = supplierEmail;
        this.supplierPhone = supplierPhone;
        this.contactPersonEmail = contactPersonEmail;
        this.contactPersonPhone = contactPersonPhone;
        this.address = address;
    }

    // Getters and Setters
    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierAgency() {
        return supplierAgency;
    }

    public void setSupplierAgency(String supplierAgency) {
        this.supplierAgency = supplierAgency;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public BigInteger getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(BigInteger supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public BigInteger getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(BigInteger contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
