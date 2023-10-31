package com.mystoreapp.storeapp.src.dao.Impl;

import com.mystoreapp.storeapp.src.dao.ShippingAddressDao;
import com.mystoreapp.storeapp.src.model.Product;
import com.mystoreapp.storeapp.src.model.QProduct;
import com.mystoreapp.storeapp.src.model.QShippingAddressModel;
import com.mystoreapp.storeapp.src.model.ShippingAddressModel;
import com.mystoreapp.storeapp.user.User;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShippingAddressDaoImpl implements ShippingAddressDao {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public List<ShippingAddressModel> getShippingAddressByUser(User user) {
        JPAQuery<ShippingAddressModel> query  = new JPAQuery<>(em);
        QShippingAddressModel shippingAddressModel = QShippingAddressModel.shippingAddressModel;
        return query.from(shippingAddressModel).where(shippingAddressModel.user.eq(user), shippingAddressModel.deleted.eq(false)).fetch();
    }

    @Override
    public ShippingAddressModel getShippingAddressById(long shippingAddressId, User user) {
        JPAQuery<ShippingAddressModel> query  = new JPAQuery<>(em);
        QShippingAddressModel shippingAddressModel = QShippingAddressModel.shippingAddressModel;
        return query.from(shippingAddressModel).where(shippingAddressModel.deleted.eq(false),shippingAddressModel.id.eq(shippingAddressId)).fetchFirst();
    }
}
