package com.mystoreapp.storeapp.src.model;

import com.mystoreapp.storeapp.src.dto.response.ShippingAddressResponse;
import com.mystoreapp.storeapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShippingAddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String addressName;
    private String addressLocation;
    private String phoneNo;
    @ManyToOne
    private User user;
    @Column(
            columnDefinition = "boolean default false",
            nullable = false
    )
    private Boolean deleted = false;
    @Builder.Default
    private double price = 0.500;
    public ShippingAddressResponse shippingResponse(){
        return  ShippingAddressResponse.builder().addressLocation(addressLocation).addressName(addressName).phoneNo(phoneNo).id(id).build();
    }
}
