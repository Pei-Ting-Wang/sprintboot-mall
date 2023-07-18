package com.penny.shoppingmall.dao;

import com.penny.shoppingmall.constant.ProductCategory;
import com.penny.shoppingmall.model.Product;
import dto.ProductRequest;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
