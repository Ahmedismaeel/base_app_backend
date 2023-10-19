package com.mystoreapp.storeapp.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest request){
        return  ResponseEntity.ok().body(authenticationService.register(request));
    }
    @PostMapping("/registerManager")
    public ResponseEntity<AuthenticationResponse> registerManager(@RequestBody RegistrationRequest request){
        return  ResponseEntity.ok().body(authenticationService.registerManager(request));
    }
    @PostMapping("/registerAdmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody RegistrationRequest request){
        return  ResponseEntity.ok().body(authenticationService.registerAdmin(request));
    }

    @GetMapping("/ahmed")
    ResponseEntity<?> testApi(){
        return ResponseEntity.ok().body("Hello Every one ");
    }
    @PostMapping("/login")
    public  ResponseEntity<?> login(@RequestBody AuthenticationRequest request){
        try {
            AuthenticationResponse response = authenticationService.login(request);
            return  ResponseEntity.ok().body(response);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
