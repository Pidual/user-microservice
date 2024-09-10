package com.emazon.usermicroservice.infrastructure.input;

import com.emazon.usermicroservice.application.dto.AuthenticationRequest;
import com.emazon.usermicroservice.application.dto.AuthenticationResponse;
import com.emazon.usermicroservice.infrastructure.security.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authRequest){
        AuthenticationResponse jwtDto = authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }

    @GetMapping("/public-access")
    public String publicAccessEndpoint(){
        return "este endpoint es publico";
    }
}
