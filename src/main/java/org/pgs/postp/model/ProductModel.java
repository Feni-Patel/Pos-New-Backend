package org.pgs.postp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Long productId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "StockQuantity", nullable = false)
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "SupplierID", nullable = false)
    private SupplierModel supplier;

    @OneToMany(mappedBy = "product")
    private List<TransactionDetailModel> transactionDetails;

    // Constructors
    public ProductModel() {
    }

    public ProductModel(String name, String description, BigDecimal price, int stockQuantity, SupplierModel supplier) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.supplier = supplier;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSupplierID() {
        return supplier != null ? supplier.getSupplierID() : null;
    }

    public void setSupplierID(Long supplierID) {
        // This method can be ignored as supplierID is managed via the supplier field
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public SupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
    }

    public List<TransactionDetailModel> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetailModel> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public Long getSupplierId() {
        return null;
    }
}
