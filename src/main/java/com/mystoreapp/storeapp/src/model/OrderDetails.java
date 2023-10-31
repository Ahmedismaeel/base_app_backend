package com.mystoreapp.storeapp.src.model;

import com.mystoreapp.storeapp.src.helper.GenericEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetails extends GenericEntity<OrderDetails> {
    @OneToOne
    private Product product;

    private double qty;


    public double getAmount(){
        return  product.getPrice() * qty;
    }

}
