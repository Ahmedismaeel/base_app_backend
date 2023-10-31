package com.mystoreapp.storeapp.src.dao;

import com.mystoreapp.storeapp.src.model.Brand;

import java.util.List;

public interface BrandDao {
    public void saveBrand(Brand brand);

    public Brand getBrandById(long id);

    public List<Brand> getAllBrand();


}
