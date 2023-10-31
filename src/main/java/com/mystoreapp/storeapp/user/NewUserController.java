package com.mystoreapp.storeapp.user;

import com.mystoreapp.storeapp.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class NewUserController {

    private final AuthenticationService authenticationService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok().body(authenticationService.getAllUserList());
    }


    @GetMapping("/byFirstName")
    public ResponseEntity<?> getUserByFirstName(@RequestParam(name = "firstName", defaultValue = "") String firstName,@RequestParam(name = "lastName", defaultValue = "") String lastName){
        return  ResponseEntity.ok().body(authenticationService.getUserByFirstName(firstName));
    }



}
