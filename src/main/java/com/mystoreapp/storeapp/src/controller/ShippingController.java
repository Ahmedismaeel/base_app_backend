package com.mystoreapp.storeapp.src.controller;

import com.mystoreapp.storeapp.src.dto.ShippingAddressDto;
import com.mystoreapp.storeapp.src.service.ShippingAddressService;
import com.mystoreapp.storeapp.user.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/shippingAddress")
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingAddressService shippingAddressService;

    @PostMapping
    public ResponseEntity<?> saveShippingAddress(@RequestBody @Valid ShippingAddressDto request, @AuthenticationPrincipal User user){
        shippingAddressService.save(request,user);
        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/user")
    public  ResponseEntity<?> getShippingAddressByUser(@AuthenticationPrincipal User user){
        return  ResponseEntity.ok().body(shippingAddressService.getUserShippingAddress(user.getId()));
    }

    @GetMapping("/{shippingId}")
    public ResponseEntity<?> getShippingAddressByUser(@PathVariable long shippingId){
        return  ResponseEntity.ok().body(shippingAddressService.getShippingById(shippingId));
    }

    @GetMapping("/all")
    public  ResponseEntity<?> getAllShippingAddress(){
        return ResponseEntity.ok().body(shippingAddressService.getAllShippingAddress());
    }

    @PutMapping("/{shippingId}")
    public  ResponseEntity<?> updateShippingAddress(
            @RequestBody @Valid ShippingAddressDto shippingAddressDto,
            @PathVariable long shippingId,
            @AuthenticationPrincipal User user ){
        shippingAddressService.updateShippingAddress(shippingId,shippingAddressDto,user);
        return ResponseEntity.ok().body("success");
    }
}
