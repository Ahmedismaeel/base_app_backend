package com.mystoreapp.storeapp.src.repository;

import com.mystoreapp.storeapp.src.dao.ShippingAddressDao;
import com.mystoreapp.storeapp.src.model.ShippingAddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddressModel,Long>, ShippingAddressDao {
}
