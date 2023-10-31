package com.mystoreapp.storeapp.src.model;

import com.mystoreapp.storeapp.src.helper.GenericEntity;
import com.mystoreapp.storeapp.user.User;
import jakarta.persistence.*;
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
@Entity
@Table(name= "_order")
public class Order extends GenericEntity<Order> {

    @OneToMany
    @JoinTable(
            name = "order_order_details",
            joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "order_details_id",referencedColumnName = "id")
    )
    private Set<OrderDetails> orderDetails;

    @ManyToOne
    private User user;

    @ManyToOne
    private  OrderStatus orderStatus;

    @ManyToOne
    private ShippingAddressModel shippingAddressModel;


    private String comment;
}
