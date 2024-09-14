package com.emazon.usermicroservice.infrastructure.input;


import com.emazon.usermicroservice.application.dto.UserDTORequest;

import com.emazon.usermicroservice.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Management", description = "Operations related to user accounts")
public class UserRestController {

    private final IUserHandler userHandler;

   // @pre authorize este decorador asegura que solo los usuarios con el rol ROLE_ADMIN pueden acceder al endpoint /users/aux_bodega.
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/aux_bodega")
    public ResponseEntity<String> addAuxBodega(@RequestBody UserDTORequest userDTORequest) {
        userHandler.saveAuxBodega(userDTORequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/client")
    public ResponseEntity<String> addClient(@RequestBody UserDTORequest userDTORequest) {
        userHandler.saveClient(userDTORequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
