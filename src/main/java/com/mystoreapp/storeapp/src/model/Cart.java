package com.mystoreapp.storeapp.src.model;

import com.mystoreapp.storeapp.src.dto.response.CartResponse;
import com.mystoreapp.storeapp.src.helper.GenericEntity;
import com.mystoreapp.storeapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends GenericEntity<Cart> {

    @OneToOne
    private User user;
    @OneToMany
    private Set<CartItem> cartItems;

    public double cartAmount(){
        double totalAmount = 0.00;
        List<CartItem> items = cartItems.stream().toList();
        for (int i = 0; i <items.size() ; i++) {
            totalAmount  =  totalAmount + items.get(i).getAmount();
        }
        return totalAmount;
    };

    public CartResponse response(){
        return  CartResponse.builder()
                .productList(cartItems)
                .totalAmount(cartAmount())
                .build();
    }


}
