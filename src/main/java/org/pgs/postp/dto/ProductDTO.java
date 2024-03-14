package org.pgs.postp.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private Long supplierId;

    // Constructors
    public ProductDTO() {
    }

    public ProductDTO(Long productId, String name, String description, BigDecimal price, int stockQuantity, Long supplierId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.supplierId = supplierId;
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

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}

    public int getStockQuantity() {return stockQuantity;}

    public void setStockQuantity(int stockQuantity) {this.stockQuantity = stockQuantity;}

    public Long getSupplierID() {return supplierId;}

    public void setSupplierID(Long supplierId) {this.supplierId = supplierId;}
}
