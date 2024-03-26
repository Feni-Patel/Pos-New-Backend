package org.pgs.postp.dto;

import java.util.Date;

public class PurchaseOrderDTO {

    private Long id;
    private String supplier;
    private String products;
    private String store;
    private Long quantity;
    private Long buyingPrice;
    private Long sellingPrice;
    private Date orderDate;
    private Date deliverDate;
    private String transportMethod;
    private String paymentMethod;
    private String status;

    // Constructor
    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(String supplier, String products, String store,
                            Long quantity, Long buyingPrice, Long sellingPrice,
                            Date orderDate, Date deliverDate, String transportMethod, String paymentMethod, String status) {
        this.supplier = supplier;
        this.products = products;
        this.store = store;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.orderDate = orderDate;
        this.deliverDate = deliverDate;
        this.transportMethod = transportMethod;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    // Getters and Setters for fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Long buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Long getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getTransportMethod() {
        return transportMethod;
    }

    public void setTransportMethod(String transportMethod) {
        this.transportMethod = transportMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}