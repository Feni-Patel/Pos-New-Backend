package org.pgs.postp.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "Customers")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Long id; // Updated field name

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private BigInteger phone;

    @Column(name = "Address") // New field for the address
    private String address;

//    @OneToMany(mappedBy = "id")
//    private List<TransactionModel> transactions;

    // Constructors
    public CustomerModel() {
    }

    public CustomerModel(String name, String email, BigInteger phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() { // Updated getter name
        return id;
    }

    public void setId(Long id) { // Updated setter name
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public List<TransactionModel> getTransactions() {
//        return transactions;
//    }
//
//    public void setTransactions(List<TransactionModel> transactions) {
//        this.transactions = transactions;
//    }
}
