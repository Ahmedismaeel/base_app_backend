package com.mystoreapp.storeapp.src.service;

import com.mystoreapp.storeapp.src.dto.BrandDto;
import com.mystoreapp.storeapp.src.model.Brand;

import java.util.List;

public interface BrandService {
    public  void save(BrandDto brand);

    public  Brand getById(long id);

    public List<Brand> getAllBrand();
}
