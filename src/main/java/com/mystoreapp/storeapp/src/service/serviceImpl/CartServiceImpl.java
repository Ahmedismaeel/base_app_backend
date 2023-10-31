package com.mystoreapp.storeapp.src.service.serviceImpl;

import com.mystoreapp.storeapp.src.dto.response.CartResponse;
import com.mystoreapp.storeapp.src.model.Cart;
import com.mystoreapp.storeapp.src.model.CartItem;
import com.mystoreapp.storeapp.src.repository.CartItemRepository;
import com.mystoreapp.storeapp.src.repository.CartRepository;
import com.mystoreapp.storeapp.src.repository.ProductRepository;
import com.mystoreapp.storeapp.src.service.CartService;
import com.mystoreapp.storeapp.src.service.ProductService;
import com.mystoreapp.storeapp.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private  final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;
    @Override
    @Transactional
    public void addItemToCart(long productId, double qty, User user) {

        var cartItem =cartItemRepository.save(CartItem.builder()
                .product(productService.getProductById(productId))
                .qty(qty)
                . build());
        Set<CartItem> itemSet = new HashSet<CartItem> ();
        itemSet.add(cartItem);
        var cart = cartRepository.getCartByUser(user);
            if(cart == null) {
          cartRepository.save(Cart.builder().cartItems(itemSet)
                        .user(user)
                        .build());
            }else{
                cart.getCartItems().add(cartItem);            }

        }

    @Override
    public CartResponse getCartByUser(User user) {
         Cart cart = cartRepository.getCartByUser(user);
        if(cart == null){
            throw  new RuntimeException("No Item Found");
        }
         return cart.response();
    }
}
