package com.penny.shoppingmall.model;

public class OrderItem {
    public OrderItem() {
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public OrderItem setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderItem setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public OrderItem setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public OrderItem setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }
    public String getProductName() {
        return productName;
    }

    public OrderItem setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OrderItem setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    private Integer orderItemId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Integer amount;
    private  String productName;
    private  String imageUrl;
}
