package com.mystoreapp.storeapp.src.dao.Impl;

import com.mystoreapp.storeapp.src.dao.CartDao;
import com.mystoreapp.storeapp.src.model.*;
import com.mystoreapp.storeapp.user.QUser;
import com.mystoreapp.storeapp.user.User;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Cart getCartByUser(User user) {
        final JPAQuery<Cart> query = new JPAQuery<>(em);
        final QCart cart = QCart.cart;
        return query.from(cart).where(cart.user.id.eq(user.getId())).fetchFirst();
        }

}
