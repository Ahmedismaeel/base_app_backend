package com.mystoreapp.storeapp.test;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
public class TestApi {

    @GetMapping("/ahmed")
    ResponseEntity<?> testApi(){
        return ResponseEntity.ok().body("Hello Every one ");
    }
}
