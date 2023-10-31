package com.mystoreapp.storeapp.src.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ShippingAddressDto {
    private String addressName;
    private String addressLocation;
    private String phoneNo;

}
