package com.mystoreapp.storeapp.src.service;

import com.mystoreapp.storeapp.src.dto.ShippingAddressDto;
import com.mystoreapp.storeapp.src.dto.response.ShippingAddressResponse;
import com.mystoreapp.storeapp.src.model.ShippingAddressModel;
import com.mystoreapp.storeapp.user.User;

import java.util.List;

public interface ShippingAddressService {

    public ShippingAddressResponse save(ShippingAddressDto shippingAddressDto, User user);
    public List<ShippingAddressResponse> getUserShippingAddress(long userId);
    public List<ShippingAddressResponse> getAllShippingAddress();

    public ShippingAddressResponse getShippingById(long shippingId);
    public void updateShippingAddress(long shippingId,ShippingAddressDto shippingAddressDto,User user);
    public void deleteShippingAddress(long shippingId);
}
