package com.penny.shoppingmall.dto;

public class OrderQueryParams {
    private  Integer userId;
    private  Integer limit;
    private  Integer offset;

    public Integer getUserId() {
        return userId;
    }

    public OrderQueryParams setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public OrderQueryParams setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public OrderQueryParams setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }
}
