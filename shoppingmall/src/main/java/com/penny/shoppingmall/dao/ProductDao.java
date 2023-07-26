package com.penny.shoppingmall.dao;

import com.penny.shoppingmall.model.Product;
import com.penny.shoppingmall.dto.ProductQueryParams;
import com.penny.shoppingmall.dto.ProductRequest;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

    void updateStock(Integer productId, Integer stock);
    Integer countProduct(ProductQueryParams productQueryParams);
}
