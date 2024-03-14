package org.pgs.postp.dto;

public class InventoryDTO {
    private Long inventoryID;
    private Long productId;
    private int quantity;

    // Constructors
    public InventoryDTO() {
    }

    public InventoryDTO(Long inventoryID, Long productId, int quantity) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
