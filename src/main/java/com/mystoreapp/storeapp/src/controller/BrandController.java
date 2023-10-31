package com.mystoreapp.storeapp.src.controller;

import com.mystoreapp.storeapp.src.dto.BrandDto;
import com.mystoreapp.storeapp.src.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;
    @PostMapping
    public ResponseEntity<?> CreateBrand(@RequestBody @Valid BrandDto request){
       brandService.save(request);
       return ResponseEntity.ok().body("Success");
    }

    @GetMapping
    public ResponseEntity<?> getAllBrand(){
        return ResponseEntity.ok().body(brandService.getAllBrand());
    }


}
