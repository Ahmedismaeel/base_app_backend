package com.mystoreapp.storeapp.src.repository;

import com.mystoreapp.storeapp.src.dao.ProductDao;
import com.mystoreapp.storeapp.src.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, ProductDao {
}
