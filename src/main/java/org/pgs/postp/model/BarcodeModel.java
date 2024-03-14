package org.pgs.postp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Barcodes")
public class BarcodeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BarcodeID")
    private Long barcodeID;

    @OneToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private ProductModel product;

    @Column(name = "BarcodeNumber", unique = true, nullable = false)
    private String barcodeNumber;

    // Constructors
    public BarcodeModel() {
    }

    public BarcodeModel(ProductModel product, String barcodeNumber) {
        this.product = product;
        this.barcodeNumber = barcodeNumber;
    }

    // Getters and Setters
    public Long getBarcodeID() {
        return barcodeID;
    }

    public void setBarcodeID(Long barcodeID) {
        this.barcodeID = barcodeID;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }
}
