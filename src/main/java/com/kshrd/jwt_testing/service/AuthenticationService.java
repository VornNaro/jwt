package com.kshrd.jwt_testing.service;

import com.kshrd.jwt_testing.entity.request.AuthenticationRequest;
import com.kshrd.jwt_testing.entity.response.AuthenticationResponse;
import com.kshrd.jwt_testing.jwtSecurityConfig.JwtAuthenticationFilter;
import com.kshrd.jwt_testing.jwtSecurityConfig.JwtUtil;
import com.kshrd.jwt_testing.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class AuthenticationService {

    private final UserServiceImp userServiceImp;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findUserByName(authenticationRequest.getUsername());
        System.out.println("User Information: " + user);
        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
