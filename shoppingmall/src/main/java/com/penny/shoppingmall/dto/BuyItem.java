package com.penny.shoppingmall.dto;

import jakarta.validation.constraints.NotNull;

public class BuyItem {
    public Integer getProductId() {
        return productId;
    }

    public BuyItem setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BuyItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @NotNull
    private Integer productId;

    @NotNull
    private Integer quantity;
}
