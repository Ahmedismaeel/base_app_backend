package com.mystoreapp.storeapp.src.service;


import com.mystoreapp.storeapp.src.dto.CategoryDto;
import com.mystoreapp.storeapp.src.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface CategoryService {

    public void save(String title , MultipartFile file);

    public List<Category> getAllCategory();
    public Category getCategoryById(long id);
}
