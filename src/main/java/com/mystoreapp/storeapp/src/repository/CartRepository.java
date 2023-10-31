package com.mystoreapp.storeapp.src.repository;

import com.mystoreapp.storeapp.src.dao.CartDao;
import com.mystoreapp.storeapp.src.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> , CartDao {
}
