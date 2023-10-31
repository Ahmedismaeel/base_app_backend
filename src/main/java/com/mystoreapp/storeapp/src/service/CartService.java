package com.mystoreapp.storeapp.src.service;

import com.mystoreapp.storeapp.src.dto.response.CartResponse;
import com.mystoreapp.storeapp.user.User;

public interface CartService {

    public void addItemToCart(long productId, double qty, User user);
    public CartResponse getCartByUser(User user);
}
