package com.emazon.usermicroservice.infrastructure.input;

import com.emazon.usermicroservice.application.dto.UserDTORequest;
import com.emazon.usermicroservice.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Crear Auxiliar de Bodega",
            description = "Crea un nuevo usuario con rol de auxiliar de bodega. Solo disponible para administradores.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Auxiliar de bodega creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de la solicitud inválidos",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Acceso denegado. Solo usuarios con rol ADMIN pueden acceder.",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/aux_bodega")
    public ResponseEntity<String> addAuxBodega(@RequestBody @Schema(description = "Datos del usuario auxiliar de bodega") UserDTORequest userDTORequest) {
        userHandler.saveAuxBodega(userDTORequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }





    @Operation(summary = "Crear Cliente",
            description = "Crea un nuevo usuario con rol de cliente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de la solicitud inválidos",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PostMapping("/client")
    public ResponseEntity<String> addClient(@RequestBody @Schema(description = "Datos del usuario cliente") UserDTORequest userDTORequest) {
        userHandler.saveClient(userDTORequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
