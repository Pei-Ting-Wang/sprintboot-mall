package com.penny.shoppingmall.service;

import com.penny.shoppingmall.dto.CreateOrderRequest;
import com.penny.shoppingmall.dto.OrderQueryParams;
import com.penny.shoppingmall.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Integer countOrder(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
