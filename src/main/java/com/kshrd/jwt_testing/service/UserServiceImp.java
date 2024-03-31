package com.kshrd.jwt_testing.service;

import com.kshrd.jwt_testing.entity.model.UserInfo;
import com.kshrd.jwt_testing.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class UserServiceImp implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userRepository.findUserByName(username);
        System.out.println("UserInfo" + userInfo);
        if (userInfo == null){
            throw new UsernameNotFoundException("User not found");
        }
        return userInfo;
    }
}
