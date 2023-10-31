package com.mystoreapp.storeapp.user;

import java.util.List;

public interface UserDao {

    public User saveUser(User user);
    public User deletUser(User user);

    public List<User> getAllUser();

    public  List<User> getUserByFirstName(String firstName);

    public List<User> getUserByLastName(String LastName);

    public  List<User> getAdminUser();
}
