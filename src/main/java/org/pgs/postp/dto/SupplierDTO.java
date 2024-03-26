package org.pgs.postp.dto;

import java.math.BigInteger;

public class SupplierDTO {

    private Long supplierID;
    private String supplierAgency;
    private String contactPerson;
    private String supplierEmail;
    private BigInteger supplierPhone;
    private String contactPersonEmail;
    private BigInteger contactPersonPhone;
    private String address;


    // Constructors
    public SupplierDTO() {
    }

    public SupplierDTO(Long supplierID, String supplierAgency, String contactPerson, String supplierEmail,
                       BigInteger supplierPhone, String contactPersonEmail, BigInteger contactPersonPhone, String address) {
        this.supplierID = supplierID;
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
