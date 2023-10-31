package com.mystoreapp.storeapp.src.model;

import com.mystoreapp.storeapp.src.helper.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem extends GenericEntity<CartItem> {

    @OneToOne
    private Product product;
    private double qty;
    public double getAmount(){
      return  product.getPrice() * qty;
    }

}
