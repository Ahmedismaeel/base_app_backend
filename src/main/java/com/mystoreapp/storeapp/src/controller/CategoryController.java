package com.mystoreapp.storeapp.src.controller;


import com.mystoreapp.storeapp.src.dao.CategoryDao;
import com.mystoreapp.storeapp.src.dto.CategoryDto;
import com.mystoreapp.storeapp.src.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    final CategoryService categoryService;
    @PostMapping(consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createCategory(@RequestPart String title,@RequestPart MultipartFile file){
        categoryService.save(title,file);
        return ResponseEntity.ok().body("success");
    }

    @GetMapping
    public  ResponseEntity<?> getAllCategory(){
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }


    @GetMapping("/{categoryId}")
    public  ResponseEntity<?> getCategoryById(@PathVariable("categoryId") long categoryId){
        return ResponseEntity.ok().body(categoryService.getCategoryById(categoryId));
    }
}
