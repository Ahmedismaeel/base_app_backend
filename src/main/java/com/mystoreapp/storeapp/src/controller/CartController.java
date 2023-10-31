package com.mystoreapp.storeapp.src.controller;

import com.mystoreapp.storeapp.src.dto.CartRequest;
import com.mystoreapp.storeapp.src.service.CartService;
import com.mystoreapp.storeapp.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private  final CartService cartService;
    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody @Valid CartRequest request,@AuthenticationPrincipal User user){
            cartService.addItemToCart(request.getProductId(),request.getQty(),user);
            return ResponseEntity.ok().body("Success");
    }
    @GetMapping("/getCart")
    public  ResponseEntity<?> getCart(@AuthenticationPrincipal User user){
        return  ResponseEntity.ok().body(cartService.getCartByUser(user));
    }
}
