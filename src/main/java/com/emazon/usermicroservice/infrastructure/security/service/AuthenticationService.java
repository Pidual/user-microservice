package com.emazon.usermicroservice.infrastructure.security.service;

import com.emazon.usermicroservice.application.dto.AuthenticationRequest;
import com.emazon.usermicroservice.application.dto.AuthenticationResponse;
import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.domain.usecase.UserUseCase;

import jakarta.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserUseCase userUseCase;
    private final JwtService jwtService;

    public AuthenticationService(AuthenticationManager authenticationManager, UserUseCase userUseCase, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userUseCase = userUseCase;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse login(@Valid AuthenticationRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
        authenticationManager.authenticate(authToken); //this line throws an error inside
        User user = userUseCase.getUserByEmail(authRequest.getEmail());
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        return new AuthenticationResponse(jwt);
    }

    private Map<String,Object> generateExtraClaims(User user) {
        Map<String,Object> extraClaims = new HashMap<>();
        extraClaims.put("email", user.getEmail());
        extraClaims.put("role", user.getRole().getRoleId());
        return extraClaims;
    }
}
