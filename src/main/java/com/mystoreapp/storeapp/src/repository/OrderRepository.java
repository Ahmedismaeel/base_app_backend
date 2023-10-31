package com.mystoreapp.storeapp.src.repository;

import com.mystoreapp.storeapp.src.dao.OrderDao;
import com.mystoreapp.storeapp.src.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>, OrderDao {
}
