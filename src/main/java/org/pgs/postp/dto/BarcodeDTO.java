package org.pgs.postp.dto;

import java.util.Arrays;

public class BarcodeDTO {
    private Long id;
    private String barcodeNumber;

    private byte[] barcodeImage;

//    private Long productId;

    public BarcodeDTO() {
    }

    public BarcodeDTO(Long id, String barcodeNumber, byte[] barcodeImage) {
        this.id = id;
        this.barcodeNumber = barcodeNumber;
        this.barcodeImage = barcodeImage;
//        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

//    public Long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }

    @Override
    public String toString() {
        return "BarcodeDTO{" +
                "id=" + id +
                ", barcodeNumber='" + barcodeNumber + '\'' +
                ", barcodeImage=" + Arrays.toString(barcodeImage) +
 //                ", productId=" + productId +
                '}';
    }
}