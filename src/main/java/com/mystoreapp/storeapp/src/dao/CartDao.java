package com.mystoreapp.storeapp.src.dao;

import com.mystoreapp.storeapp.src.model.Cart;
import com.mystoreapp.storeapp.user.User;

public interface CartDao {


     public Cart getCartByUser(User user);
}
