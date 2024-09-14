package com.emazon.usermicroservice.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Datos requeridos para la autenticación")
public class AuthenticationRequest {

    @Schema(description = "Correo electrónico del usuario", example = "usuario@ejemplo.com")
    @NotBlank
    @Email
    private String email;

    @Schema(description = "Contraseña del usuario", example = "contraseñaSegura123")
    @NotBlank
    private String password;

}
