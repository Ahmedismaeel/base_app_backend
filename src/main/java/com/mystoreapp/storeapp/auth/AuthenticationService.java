package com.mystoreapp.storeapp.auth;


import com.mystoreapp.storeapp.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest request);
    AuthenticationResponse register(RegistrationRequest request);
    AuthenticationResponse registerManager(RegistrationRequest request);
    AuthenticationResponse registerAdmin(RegistrationRequest request);

    List<User> getAllUserList();
    List<User> getAllUserJpa();
    List<User> getUserByFirstName(String firstName);
    List<User> getUserByLastName(String lastName);
    List<User> getAdminUserList();

    List<User> getUserById(Integer id);
}
