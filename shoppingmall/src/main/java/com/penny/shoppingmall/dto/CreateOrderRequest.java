package com.penny.shoppingmall.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateOrderRequest {
    @NotEmpty
    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public CreateOrderRequest setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
        return this;
    }

    private List<BuyItem> buyItemList;

}
