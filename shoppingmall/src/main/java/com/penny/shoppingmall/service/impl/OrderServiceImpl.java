package com.penny.shoppingmall.service.impl;

import com.penny.shoppingmall.dao.OrderDao;
import com.penny.shoppingmall.dao.ProductDao;
import com.penny.shoppingmall.dto.BuyItem;
import com.penny.shoppingmall.dto.CreateOrderRequest;
import com.penny.shoppingmall.model.Order;
import com.penny.shoppingmall.model.OrderItem;
import com.penny.shoppingmall.model.Product;
import com.penny.shoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order=orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList=orderDao.getOrderItemById(orderId);

        order.setOrderItemList(orderItemList);

        return  order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount=0;
        List<OrderItem> orderItemList = new ArrayList<>();
        for(BuyItem buyItem :createOrderRequest.getBuyItemList()){
            Product product=productDao.getProductById(buyItem.getProductId());
            int amount=buyItem.getQuantity()*product.getPrice();
            totalAmount = totalAmount+amount;

            //轉換 BuyItem to OrderItem
            OrderItem orderItem=new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);
            orderItemList.add(orderItem);
        }
        Integer orderId = orderDao.createOrder(userId,totalAmount);

        orderDao.createOrderItem(orderId,orderItemList);

        return orderId;
    }
}
