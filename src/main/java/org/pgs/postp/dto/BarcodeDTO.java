package org.pgs.postp.dto;

public class BarcodeDTO {
    private Long id;
    private String barcodeNumber;
    private Long productId;

    public BarcodeDTO() {
    }

    public BarcodeDTO(Long id, String barcodeNumber, Long productId) {
        this.id = id;
        this.barcodeNumber = barcodeNumber;
        this.productId = productId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "BarcodeDTO{" +
                "id=" + id +
                ", barcodeNumber='" + barcodeNumber + '\'' +
                ", productId=" + productId +
                '}';
    }
}
