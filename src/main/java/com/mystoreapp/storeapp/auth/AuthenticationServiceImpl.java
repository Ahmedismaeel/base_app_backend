package com.mystoreapp.storeapp.auth;

import com.mystoreapp.storeapp.config.JwtService;
import com.mystoreapp.storeapp.user.Role;
import com.mystoreapp.storeapp.user.User;
import com.mystoreapp.storeapp.user.UserDao;
import com.mystoreapp.storeapp.user.UserRepository;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements  AuthenticationService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;

    @Override
    public AuthenticationResponse register(RegistrationRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.USER)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public AuthenticationResponse registerManager(RegistrationRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.MANAGER)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public AuthenticationResponse registerAdmin(RegistrationRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.ADMIN)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public List<User> getAllUserList() {
        return userDao.getAllUser();
    }

    @Override
    public List<User> getAllUserJpa() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        return userDao.getUserByFirstName(firstName);
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        return userDao.getUserByLastName(lastName);
    }

    @Override
    public List<User> getAdminUserList() {
        return userDao.getAdminUser();
    }

    @Override
    public List<User> getUserById(Integer lastName) {
        return null;
    }


    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);

       return  AuthenticationResponse.builder()
                .token(jwt)
                .build();

    }


}
