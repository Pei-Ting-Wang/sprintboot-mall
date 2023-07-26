package com.penny.shoppingmall.service.impl;

import com.penny.shoppingmall.dao.OrderDao;
import com.penny.shoppingmall.dao.ProductDao;
import com.penny.shoppingmall.dao.UserDao;
import com.penny.shoppingmall.dto.BuyItem;
import com.penny.shoppingmall.dto.CreateOrderRequest;
import com.penny.shoppingmall.dto.OrderQueryParams;
import com.penny.shoppingmall.model.Order;
import com.penny.shoppingmall.model.OrderItem;
import com.penny.shoppingmall.model.Product;
import com.penny.shoppingmall.model.User;
import com.penny.shoppingmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    private  final  static Logger log= LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
        List<Order> orderList=orderDao.getOrders(orderQueryParams);
        for(Order order : orderList){
            List<OrderItem> orderItemList=orderDao.getOrderItemById(order.getOrderId());
            order.setOrderItemList(orderItemList);
        }
        return orderList;
    }

    @Override
    public Integer countOrder(OrderQueryParams orderQueryParams) {
        return orderDao.countOrder(orderQueryParams);
    }

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
        User user =userDao.getUserById(userId);
        if(user == null){
            log.warn("該user{}不存在",userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        int totalAmount=0;
        List<OrderItem> orderItemList = new ArrayList<>();
        for(BuyItem buyItem :createOrderRequest.getBuyItemList()){
            Product product=productDao.getProductById(buyItem.getProductId());

            if(product == null){
                log.warn("商品 {} 不存在",buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            else if(product.getStock() < buyItem.getQuantity()){
                log.warn("商品 {} 庫存不存,  剩餘:{}",buyItem.getProductId(),product.getStock());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
             }

            productDao.updateStock(product.getProductId(),product.getStock()-buyItem.getQuantity());

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
