package com.mystoreapp.storeapp.src.controller;


import com.mystoreapp.storeapp.src.dto.OrderDto;
import com.mystoreapp.storeapp.src.service.OrderService;
import com.mystoreapp.storeapp.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {


    private  final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody @Valid OrderDto request ,  @AuthenticationPrincipal User user){
           
        return ResponseEntity.ok().body( orderService.placOrder(user,request));
    }
}
