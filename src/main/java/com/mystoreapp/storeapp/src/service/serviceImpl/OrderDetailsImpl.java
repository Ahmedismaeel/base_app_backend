package com.mystoreapp.storeapp.src.service.serviceImpl;

import com.mystoreapp.storeapp.src.repository.OrderRepository;
import com.mystoreapp.storeapp.src.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailsImpl {
    final OrderRepository orderRepository;
    final CartService cartService;
}
