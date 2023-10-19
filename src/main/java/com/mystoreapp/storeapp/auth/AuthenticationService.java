package com.mystoreapp.storeapp.auth;


import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest request);
    AuthenticationResponse register(RegistrationRequest request);
    AuthenticationResponse registerManager(RegistrationRequest request);
    AuthenticationResponse registerAdmin(RegistrationRequest request);
}
