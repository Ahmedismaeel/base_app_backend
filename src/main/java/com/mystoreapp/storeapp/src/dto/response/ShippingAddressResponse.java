package com.mystoreapp.storeapp.src.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ShippingAddressResponse {
    long id;
    private String addressName;
    private String addressLocation;
    private String phoneNo;

}
