package com.mystoreapp.storeapp.src.repository;

import com.mystoreapp.storeapp.src.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus,Long> {

}
