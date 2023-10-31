package com.mystoreapp.storeapp.src.dto.response;

import com.mystoreapp.storeapp.src.model.CartItem;
import com.mystoreapp.storeapp.src.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {

    private double totalAmount;
    private Set<CartItem> productList ;

}
