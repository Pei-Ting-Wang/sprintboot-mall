package com.penny.shoppingmall.dao;

import com.penny.shoppingmall.model.Product;
import dto.ProductRequest;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
