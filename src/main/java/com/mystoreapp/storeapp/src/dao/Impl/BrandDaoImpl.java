package com.mystoreapp.storeapp.src.dao.Impl;

import com.mystoreapp.storeapp.src.dao.BrandDao;
import com.mystoreapp.storeapp.src.model.Brand;
import com.mystoreapp.storeapp.src.model.QBrand;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BrandDaoImpl implements BrandDao {
    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public void saveBrand(Brand brand) {
            em.persist(brand);
    }

    @Override
    public Brand getBrandById(long id) {
        JPAQuery<Brand> query = new JPAQuery<>(em);
        QBrand brand= QBrand.brand;
         return query.from(brand).where(brand.id.eq(id)).fetchFirst();
    }

    @Override
    public List<Brand> getAllBrand() {
        JPAQuery<Brand> query = new JPAQuery<>(em);
        QBrand brand= QBrand.brand;
        return query.from(brand).where().fetch();
    }
}
