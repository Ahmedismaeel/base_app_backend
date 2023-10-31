package com.mystoreapp.storeapp.src.service.serviceImpl;

import com.mystoreapp.storeapp.src.dto.ShippingAddressDto;
import com.mystoreapp.storeapp.src.dto.response.ShippingAddressResponse;
import com.mystoreapp.storeapp.src.model.ShippingAddressModel;
import com.mystoreapp.storeapp.src.repository.ShippingAddressRepository;
import com.mystoreapp.storeapp.src.service.ShippingAddressService;
import com.mystoreapp.storeapp.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShippingAddressImpl implements ShippingAddressService {

    private  final ShippingAddressRepository shippingAddressRepository;

    @Override
    public ShippingAddressResponse save(ShippingAddressDto request, User user) {
        return shippingAddressRepository.save(ShippingAddressModel.builder().addressName(request.getAddressName()).addressLocation(request.getAddressLocation()).phoneNo(request.getPhoneNo()).user(user). build()).shippingResponse();
    }

    @Override
    public List<ShippingAddressResponse> getUserShippingAddress(long userId) {
        return shippingAddressRepository.findAll().stream().map(shippingAddressModel ->  shippingAddressModel.shippingResponse()).collect(Collectors.toList());
    }

    @Override
    public List<ShippingAddressResponse> getAllShippingAddress() {
        return shippingAddressRepository.findAll().stream().map(shippingAddressModel -> shippingAddressModel.shippingResponse()).collect(Collectors.toList());
    }

    @Override
    public ShippingAddressResponse getShippingById(long shippingId) {
        return shippingAddressRepository.findById(shippingId).orElseThrow().shippingResponse();
    }

    @Override
    public void updateShippingAddress(long shippingId, ShippingAddressDto request,User user) {
         shippingAddressRepository.save(ShippingAddressModel.builder().id(shippingId).addressName(request.getAddressName()).addressLocation(request.getAddressLocation()).phoneNo(request.getPhoneNo()).user(user). build());
        return;
    }

    @Override
    public void deleteShippingAddress(long shippingId) {
        ShippingAddressModel shippingAddressModel =shippingAddressRepository.findById(shippingId).orElseThrow();
        shippingAddressModel.setDeleted(true);
             shippingAddressRepository.save(shippingAddressModel);
    }
}
