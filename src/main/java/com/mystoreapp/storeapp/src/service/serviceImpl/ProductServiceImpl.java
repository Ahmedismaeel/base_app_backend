package com.mystoreapp.storeapp.src.service.serviceImpl;

import com.mystoreapp.storeapp.src.dto.ProductDto;
import com.mystoreapp.storeapp.src.helper.FileNameHelper;
import com.mystoreapp.storeapp.src.helper.FileSystemStorage;
import com.mystoreapp.storeapp.src.model.Brand;
import com.mystoreapp.storeapp.src.model.Category;
import com.mystoreapp.storeapp.src.model.Product;
import com.mystoreapp.storeapp.src.repository.BrandRepository;
import com.mystoreapp.storeapp.src.repository.CategoryRepository;
import com.mystoreapp.storeapp.src.repository.ProductRepository;
import com.mystoreapp.storeapp.src.service.ProductService;
import com.mystoreapp.storeapp.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

   private final ProductRepository productRepository;
   private final CategoryRepository  categoryRepository;
   private final BrandRepository brandRepository;
   private final FileSystemStorage fileSystemStorage;

    @Override
    @Transactional
    public void saveProduct(ProductDto productDto, User user) {

        String image = FileNameHelper.getFileName(productDto.getImage());
        fileSystemStorage.store(productDto.getImage(),image);
        List<String> imageList = new ArrayList<String>();
        for (int i = 0; i < productDto.getSliderImages().size(); i++) {
            String imageName = FileNameHelper.getFileName(productDto.getSliderImages().get(i));
            imageList.add(imageName);
            fileSystemStorage.store(productDto.getSliderImages().get(i),imageName);
        }
         Product product = productRepository.save(Product
                .builder()
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                        .image(image)
                        .sliderImages(imageList)
                         .user(user)
                .description(productDto.getDescription())
                .build());

        Category category =  categoryRepository.findById(productDto.getCategoryId()).orElseThrow();
        category.getProduct().add(product);

        Brand  brand =  brandRepository.findById(productDto.getBrandId()).orElseThrow();
        brand.getProductList().add(product);

    }

    @Override
    public Product getProductById(long id) {
        var product = productRepository.getProductById(id);
        if(product == null){
            throw new RuntimeException("No Product Found");
        }
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProductList(

        );
    }

    @Override
    public List<Product> getProductByCategoryId(long id) {
        var category =  categoryRepository.findById(id).orElseThrow();
      return  category.getProduct().stream().toList();
    }

    @Override
    public List<Product> getProductLikeName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByUser(User user) {
        return null;
    }

    @Override
    public void updateProduct(ProductDto productDto, User user) {

    }

    @Override
    public void deleteProduct(long productId, User user) {

    }
}
