package com.penny.shoppingmall.service;

import com.penny.shoppingmall.model.Product;
import dto.ProductRequest;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
