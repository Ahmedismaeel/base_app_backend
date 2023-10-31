package com.mystoreapp.storeapp.src.service.serviceImpl;

import com.mystoreapp.storeapp.src.dao.BrandDao;
import com.mystoreapp.storeapp.src.dto.BrandDto;
import com.mystoreapp.storeapp.src.model.Brand;
import com.mystoreapp.storeapp.src.repository.BrandRepository;
import com.mystoreapp.storeapp.src.service.BrandService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {


    private final BrandRepository brandDao;
    @Override
    public void save(BrandDto brand) {
        brandDao.save(Brand.builder().title(brand.getTitle()).image(brand.getImage()).build());
    }

    @Override
    public Brand getById(long id) {
        return brandDao.getBrandById(id);
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandDao.getAllBrand();
    }
}
