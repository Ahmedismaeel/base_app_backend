package com.mystoreapp.storeapp.src.dao.Impl;

import com.mystoreapp.storeapp.src.dao.ProductDao;
import com.mystoreapp.storeapp.src.model.Product;
import com.mystoreapp.storeapp.src.model.QBrand;
import com.mystoreapp.storeapp.src.model.QCategory;
import com.mystoreapp.storeapp.src.model.QProduct;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ProductDaoImpl implements ProductDao {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    @Override
    @Transactional
    public void saveProduct(Product product) {
        em.persist(product);
    }

    @Override
    public Product getProductById(long id) {
        JPAQuery<Product> query  = new JPAQuery<>(em);
        QProduct product = QProduct.product;
        return query.from(product).where(product.id.eq(id), product.deleted.eq(false)).fetchFirst();
    }

    @Override
    public List<Product> getAllProductList() {
        JPAQuery<Product> query  = new JPAQuery<>(em);
        QProduct product = QProduct.product;
        return query.from(product).where(product.deleted.eq(false)).fetch();
    }

    @Override
    public List<Product> getProductsByCategoryId(long categoryId) {
        JPAQuery<Product> query  = new JPAQuery<>(em);
        QProduct product = QProduct.product;
        QCategory category = QCategory.category;
        return  List.of();//query.from(product).innerJoin(product.category,category).on(category.id.eq(categoryId)). fetch();
    }

    @Override
    public List<Product> getProductByBrandId(long branId) {
        JPAQuery<Product> query  = new JPAQuery<>(em);
        QProduct product = QProduct.product;
        QBrand brand = QBrand.brand;
          return  List.of();//query.from(product).innerJoin(product.brand,brand).on(brand.id.eq(branId)).fetch();
    }

    @Override
    public List<Product> getProductLike(String productName) {
        JPAQuery<Product> query  = new JPAQuery<>(em);
        QProduct product = QProduct.product;
        return query.from(product).where(product.title.like(productName)).fetch();
    }
}
