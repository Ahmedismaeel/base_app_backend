package com.mystoreapp.storeapp.src.model;


import com.mystoreapp.storeapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    @Column(nullable = false)
    private double price;
    private String image;
    @ElementCollection
    private List<String> sliderImages = new ArrayList<>();
    @ManyToOne
    private User user;
    @Builder.Default
    private Boolean deleted = false;

}
