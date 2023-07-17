package com.penny.shoppingmall.dao;

import com.penny.shoppingmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
