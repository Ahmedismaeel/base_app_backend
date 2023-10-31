package com.mystoreapp.storeapp.src.dao;

import com.mystoreapp.storeapp.src.model.ShippingAddressModel;
import com.mystoreapp.storeapp.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShippingAddressDao {

    public List<ShippingAddressModel> getShippingAddressByUser(User user);

    public ShippingAddressModel getShippingAddressById(long shippingAddressId ,User user);



}
