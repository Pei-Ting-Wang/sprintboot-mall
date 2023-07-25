package com.penny.shoppingmall.service;

import com.penny.shoppingmall.dto.CreateOrderRequest;
import com.penny.shoppingmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
