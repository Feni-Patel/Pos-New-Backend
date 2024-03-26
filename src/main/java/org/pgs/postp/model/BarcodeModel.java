package org.pgs.postp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Barcodes")
public class BarcodeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BarcodeID")
    private Long barcodeID;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
//    private ProductModel product;

    @Column(name = "BarcodeNumber", unique = true, nullable = false)
    private String barcodeNumber;

    // Additional field
    @Lob
    @Column(name = "BarcodeImage")
    private byte[] barcodeImage;

    // Constructors
    public BarcodeModel() {
    }

    public BarcodeModel(Long barcodeID, String barcodeNumber, byte[] barcodeImage) {
        this.barcodeID = barcodeID;
//        this.product = product;
        this.barcodeNumber = barcodeNumber;
        this.barcodeImage = barcodeImage;
    }

    // Getters and Setters
    public Long getBarcodeID() {
        return barcodeID;
    }

    public void setBarcodeID(Long barcodeID) {
        this.barcodeID = barcodeID;
    }

//    public ProductModel getProduct() {
//        return product;
//    }
//
//    public void setProduct(ProductModel product) {
//        this.product = product;
//    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public byte[] getBarcodeImage() {
        return barcodeImage;
    }

    public void setBarcodeImage(byte[] barcodeImage) {
        this.barcodeImage = barcodeImage;
    }
}