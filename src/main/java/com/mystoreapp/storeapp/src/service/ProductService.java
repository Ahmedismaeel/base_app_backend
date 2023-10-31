package com.mystoreapp.storeapp.src.service;

import com.mystoreapp.storeapp.src.dto.ProductDto;
import com.mystoreapp.storeapp.src.model.Product;
import com.mystoreapp.storeapp.user.User;

import java.util.List;

public interface ProductService {

    public void saveProduct(ProductDto productDto, User user);
    public Product getProductById(long id);

    public List<Product> getAllProduct();

    public List<Product> getProductByCategoryId(long id);
    public List<Product> getProductLikeName(String name);
    public List<Product> getProductsByUser(User user);
    public void updateProduct(ProductDto productDto,User user);
    public void deleteProduct(long productId, User user);

}
