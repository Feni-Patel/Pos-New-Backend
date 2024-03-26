package org.pgs.postp.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {

    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal tax;
    private BigDecimal total;
    private BigDecimal stockQuantity;
    private BigDecimal purchasePrice;
    private String barcodeNumber;
    private byte[] barcodeImage;
    private List<Long> supplierIds;

    // Constructors
    public ProductDTO() {
    }

    public ProductDTO(Long productId, String name, String description, BigDecimal price, BigDecimal tax, BigDecimal total, BigDecimal stockQuantity, BigDecimal purchasePrice, String barcodeNumber, byte[] barcodeImage, List<Long> supplierIds) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.tax = tax;
        this.total = total;
        this.stockQuantity = stockQuantity;
        this.purchasePrice = purchasePrice;
        this.barcodeNumber = barcodeNumber;
        this.barcodeImage = barcodeImage;
        this.supplierIds = supplierIds;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(BigDecimal stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public BigDecimal getPurchasePrice() { return purchasePrice; }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public List<Long> getSupplierIds() {
        return supplierIds;
    }

    public void setSupplierIds(List<Long> supplierIds) {
        this.supplierIds = supplierIds;
    }

}