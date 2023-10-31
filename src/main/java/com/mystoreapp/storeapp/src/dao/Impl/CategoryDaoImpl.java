package com.mystoreapp.storeapp.src.dao.Impl;


import com.mystoreapp.storeapp.src.dao.CategoryDao;
import com.mystoreapp.storeapp.src.model.Category;
import com.mystoreapp.storeapp.src.model.QCategory;
import com.mystoreapp.storeapp.user.User;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void saveCategory(Category category) {
        em.persist(category);
        return ;
    }

    @Override
    public Category getCategoryById(long id) {

        final JPAQuery<Category> query = new JPAQuery<>(em);

        final QCategory category = QCategory.category;

        return query.from(category).where(category.id.eq(id)).fetchFirst();

    }

    @Override
    public List<Category> getAllCategory() {
        final JPAQuery<Category> query = new JPAQuery<>(em);
        final QCategory category = QCategory.category;
        return query.from(category).where().fetch();
    }
}
