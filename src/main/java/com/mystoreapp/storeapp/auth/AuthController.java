package com.mystoreapp.storeapp.auth;

import com.mystoreapp.storeapp.helper.ErrorDto;
import com.mystoreapp.storeapp.user.UserDao;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserDao userDao;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid RegistrationRequest request){
        return  ResponseEntity.ok().body(authenticationService.register(request));
    }
    @PostMapping("/registerManager")
    public ResponseEntity<AuthenticationResponse> registerManager(@RequestBody @Valid RegistrationRequest request){
        return  ResponseEntity.ok().body(authenticationService.registerManager(request));
    }
    @PostMapping("/registerAdmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody @Valid RegistrationRequest request){
        return  ResponseEntity.ok().body(authenticationService.registerAdmin(request));
    }

    @GetMapping("/ahmed")
    ResponseEntity<?> testApi(){
        return ResponseEntity.ok().body("Hello Every one ");
    }
    @PostMapping("/login")
    public  ResponseEntity<?> login(@RequestBody @Valid AuthenticationRequest request, Errors errors){

            AuthenticationResponse response = authenticationService.login(request);
            return  ResponseEntity.ok().body(response);

    }

}
