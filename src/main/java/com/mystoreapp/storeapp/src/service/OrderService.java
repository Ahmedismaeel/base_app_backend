package com.mystoreapp.storeapp.src.service;

import com.mystoreapp.storeapp.src.dto.OrderDto;
import com.mystoreapp.storeapp.src.model.Order;
import com.mystoreapp.storeapp.user.User;

import java.util.Set;

public interface OrderService {

    public long placOneOrder(User user, OrderDto orderDto);
    public Set<Order> placOrder(User user, OrderDto orderDto);
}
