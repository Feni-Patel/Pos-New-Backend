package org.pgs.postp.dto;

import java.math.BigDecimal;

public class InventoryDTO {
    private Long inventoryID;
    private Long productId;
    private BigDecimal quantity;

    // Constructors
    public InventoryDTO() {
    }

    public InventoryDTO(Long inventoryID, Long productId, BigDecimal quantity) {
        this.inventoryID = inventoryID;
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Long inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
