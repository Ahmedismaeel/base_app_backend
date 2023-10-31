package com.mystoreapp.storeapp.src.controller;

import com.mystoreapp.storeapp.src.dto.ProductDto;
import com.mystoreapp.storeapp.src.service.ProductService;
import com.mystoreapp.storeapp.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(@ModelAttribute ProductDto request , @AuthenticationPrincipal User user){
        productService.saveProduct(request,user);
        return  ResponseEntity.ok().body("Success");
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/{productId}")
    public  ResponseEntity<?> getProductById(@PathVariable long productId){
        return ResponseEntity.ok().body(productService.getProductById(productId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getProductByCategoryId(@PathVariable long categoryId){
        return ResponseEntity.ok().body(productService.getProductByCategoryId(categoryId));
    }


}
