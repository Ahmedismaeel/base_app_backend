package com.mystoreapp.storeapp.src.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotNull
    @NotEmpty
    private String title;
    private String description;

    @NotNull
    private double price;
    private MultipartFile image;
    private List<MultipartFile> sliderImages;
    @Min(value = 1, message = "brandId should not be null or zero")
    private long brandId;
    @Min(value = 1, message = "categoryId should not be null or zero")
    private long categoryId;
}
