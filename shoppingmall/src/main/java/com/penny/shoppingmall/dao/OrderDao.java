package com.penny.shoppingmall.dao;

import com.penny.shoppingmall.dto.CreateOrderRequest;
import com.penny.shoppingmall.model.Order;
import com.penny.shoppingmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemById(Integer orderId);
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItem(Integer orderId, List<OrderItem> orderItemList);
}
