package com.mystoreapp.storeapp.test;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminApi {

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('admin:read')")
    ResponseEntity<?> testAdminApi(){
        return ResponseEntity.ok().body("Welcome to Admin Api");
    }
 }
