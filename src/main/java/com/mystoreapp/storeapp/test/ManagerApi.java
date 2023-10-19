package com.mystoreapp.storeapp.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/management")
public class ManagerApi {



    @GetMapping("/test")
    ResponseEntity<?> testManagerApi(){
        return ResponseEntity.ok().body("Welcome on Manager Api");
    }
}
