package com.upgrad.ECOM.service;

import com.upgrad.ECOM.entity.Product;

import java.util.List;

public interface ProductService {
    Product acceptNewProduct(Product product);
    Product getProductDetails(int productId);
    List<Product> findAllProductsForOrder(int orderId);
    List<Product> findAllProducts();
}
