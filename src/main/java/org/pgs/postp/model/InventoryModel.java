package org.pgs.postp.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Inventory")
public class InventoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventoryID")
    private Long inventoryID;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private ProductModel product;

    @Column(name = "Quantity", nullable = false)
    private BigDecimal quantity;

    // Constructors
    public InventoryModel() {
    }

    public InventoryModel(ProductModel product, BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Long inventoryID) {
        this.inventoryID = inventoryID;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {this.product = product;}

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
