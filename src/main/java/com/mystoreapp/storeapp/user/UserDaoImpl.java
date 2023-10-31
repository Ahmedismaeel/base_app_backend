package com.mystoreapp.storeapp.user;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;


    @Override
    public User saveUser(User user) {

        em.persist(user);
        return user;
    }

    @Override
    public User deletUser(User user) {
         em.remove(user);
         return user;  
    }

    @Override
    public List<User> getAllUser() {
        final JPAQuery<User> query = new JPAQuery<>(em);
        final QUser user = QUser.user;
      return  query.from(user).where().fetch();
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        final JPAQuery<User> query = new JPAQuery<>(em);
        final QUser user = QUser.user;
        return query.from(user).where(user.firstName.eq(firstName)).fetch();
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        final JPAQuery<User> query = new JPAQuery<>(em);
        final QUser user = QUser.user;
        return query.from(user).where(user.lastName.eq(lastName)).fetch();
    }

    @Override
    public List<User> getAdminUser() {

        final JPAQuery<User> query = new JPAQuery<>(em);
        final QUser user = QUser.user;
        return query.from(user).where(user.role.eq(Role.ADMIN)).fetch();
    }
}
