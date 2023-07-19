package com.penny.shoppingmall.dao;

import com.penny.shoppingmall.constant.ProductCategory;
import com.penny.shoppingmall.model.Product;
import dto.ProductQueryParams;
import dto.ProductRequest;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
    Integer countProduct(ProductQueryParams productQueryParams);
}
