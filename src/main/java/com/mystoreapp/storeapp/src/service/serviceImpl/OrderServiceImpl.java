package com.mystoreapp.storeapp.src.service.serviceImpl;

import com.mystoreapp.storeapp.src.dto.CartRequest;
import com.mystoreapp.storeapp.src.dto.OrderDto;
import com.mystoreapp.storeapp.src.model.CartItem;
import com.mystoreapp.storeapp.src.model.Order;
import com.mystoreapp.storeapp.src.model.OrderDetails;
import com.mystoreapp.storeapp.src.repository.*;
import com.mystoreapp.storeapp.src.service.CartService;
import com.mystoreapp.storeapp.src.service.OrderService;
import com.mystoreapp.storeapp.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
   private final OrderRepository orderRepository;
   private final OrderDetailsRepository orderDetailsRepository;
   private final CartRepository cartRepository;
   private final ShippingAddressRepository shippingAddressRepository;
   private final OrderStatusRepository orderStatusRepository;

    @Override
    @Transactional
    public long placOneOrder(User user, OrderDto orderDto) {
        var cart =  cartRepository.getCartByUser(user);
        if(cart == null){
            throw new RuntimeException("No Cart Found") ;
        }
        if(cart.getCartItems().size() == 0){
            throw new RuntimeException("The Cart Is Empty") ;
        }
        Set<OrderDetails> orderDetailsSet = new HashSet<OrderDetails>();
        cart.getCartItems().forEach(cartItem -> orderDetailsSet.add(OrderDetails.builder()
                .product(cartItem.getProduct()).qty(cartItem.getQty())
                .build()));
        ;
        var order =  orderRepository.save(Order.builder()
                .orderDetails(new HashSet<OrderDetails>(orderDetailsRepository.saveAll(orderDetailsSet)))
                .user(user)
                .orderStatus(orderStatusRepository.findById(1L).orElseThrow())
                .comment(orderDto.getComment())
                .shippingAddressModel(shippingAddressRepository.findById(orderDto.getShippingAddressId()).orElseThrow())
                .build());
        return order.getId();
    }
    @Override
    @Transactional
    public Set<Order> placOrder(User user, OrderDto orderDto) {
     var cart =  cartRepository.getCartByUser(user);
     if(cart == null){
         throw new RuntimeException("No Cart Found") ;
     }
     if(cart.getCartItems().size() == 0){
         throw new RuntimeException("The Cart Is Empty") ;
     }
        Map<Long, List<CartItem>> cartItemsMap = new HashMap<>();
        for (CartItem item : cart.getCartItems()) {
            long id = item.getId();
            cartItemsMap.computeIfAbsent(id, k -> new ArrayList<>()).add(item);
        }
        List<List<CartItem>> splitLists = new ArrayList<>(cartItemsMap.values());

        Set<Order> ordersList  = new HashSet<Order>();
        for (List<CartItem> splitList : splitLists) {
            Set<OrderDetails> orderDetailsSet = new HashSet<OrderDetails>();
            splitList.forEach(cartItem -> orderDetailsSet.add(OrderDetails.builder()
                    .product(cartItem.getProduct()).qty(cartItem.getQty())
                    .build()));

            var order =  orderRepository.save(Order.builder()
                    .orderDetails(new HashSet<OrderDetails>(orderDetailsRepository.saveAll(orderDetailsSet)))
                    .user(user)
                    .orderStatus(orderStatusRepository.findById(1L).orElseThrow())
                    .comment(orderDto.getComment())
                    .shippingAddressModel(shippingAddressRepository.findById(orderDto.getShippingAddressId()).orElseThrow())
                    .build());
            ordersList.add(order);
        }


        return ordersList;
    }
}
