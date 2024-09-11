package com.emazon.usermicroservice.infrastructure.input;


import com.emazon.usermicroservice.application.dto.UserDTORequest;

import com.emazon.usermicroservice.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Management", description = "Operations related to user accounts")
public class UserRestController {

    private final IUserHandler userHandler;


    @PostMapping("/aux_bodega")
    public ResponseEntity<String> addUser(@RequestBody UserDTORequest userDTORequest) {
        userHandler.saveUser(userDTORequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    public ResponseEntity<String> addAdmin(@RequestBody UserDTORequest userDTORequest) {
        userHandler.saveAdmin(userDTORequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
