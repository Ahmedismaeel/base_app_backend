package com.mystoreapp.storeapp.src.dao;

import com.mystoreapp.storeapp.src.model.Product;

import java.util.List;

public interface ProductDao {

    public void saveProduct(Product product);
    public  Product getProductById(long id);

    public List<Product> getAllProductList();

    public List<Product> getProductsByCategoryId(long CategoryId);

    public List<Product> getProductByBrandId(long branId);
    public List<Product> getProductLike(String productName);


}
