package com.kshrd.jwt_testing.controller;

import com.kshrd.jwt_testing.entity.request.AuthenticationRequest;
import com.kshrd.jwt_testing.entity.response.AuthenticationResponse;
import com.kshrd.jwt_testing.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(
            @RequestBody AuthenticationRequest authenticationRequest
            ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

}
