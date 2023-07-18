package com.penny.shoppingmall.service;

import com.penny.shoppingmall.model.Product;
import dto.ProductRequest;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
