package com.emazon.usermicroservice.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Respuesta de autenticación con el token JWT")
public class AuthenticationResponse {

    @Schema(description = "Token JWT generado", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")

    private String jwt;



}
