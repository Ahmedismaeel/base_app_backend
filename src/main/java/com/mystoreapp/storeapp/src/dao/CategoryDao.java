package com.mystoreapp.storeapp.src.dao;

import com.mystoreapp.storeapp.src.model.Category;

import java.util.List;

public interface CategoryDao {


    public void saveCategory(Category category);

    public  Category getCategoryById(long id);

    public List<Category> getAllCategory();
}
