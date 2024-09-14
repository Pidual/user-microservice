package com.emazon.usermicroservice.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static com.emazon.usermicroservice.common.Constants.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Datos requeridos para crear un nuevo usuario")
public class UserDTORequest {

    @Schema(description = "Nombre del usuario", example = "Luis")
    @NotBlank(message = USER_FIRST_NAME_ERROR_MESSAGE)
    private String firstName;

    @Schema(description = "Apellido del usuario", example = "Rodríguez")
    @NotBlank(message = USER_SECOND_NAME_ERROR_MESSAGE)
    private String lastName;

    @Schema(description = "Documento de identidad del usuario (solo dígitos)", example = "123456789")
    @NotBlank(message = DOCUMENT_ID_ERROR_MESSAGE)
    @Pattern(regexp = "\\d+", message = DOCUMENT_ID_ERROR_MESSAGE)
    private String documentId;

    @Schema(description = "Fecha de nacimiento del usuario. Debe ser una fecha en el pasado", example = "1990-05-15")
    @NotNull(message = EMPTY_BIRTHDATE_ERROR_MESSAGE)
    @Past(message = UNDERAGE_ERROR_MESSAGE)
    private LocalDate birthDate;

    @Schema(description = "Correo electrónico válido del usuario", example = "usuario@ejemplo.com")
    @NotBlank(message = WRONG_EMAIL_ERROR_MESSAGE)
    @Email(message = WRONG_EMAIL_ERROR_MESSAGE)
    private String email;

    @Schema(description = "Contraseña del usuario", example = "contraseñaSegura123")
    @NotBlank(message = EMPTY_PASSWORD_ERROR_MESSAGE)
    private String password;

    @Schema(description = "Número de teléfono del usuario, con un máximo de 13 caracteres y con el símbolo '+' opcional", example = "+573001234567")
    @NotBlank(message = PHONE_NUMBER_ERROR_MESSAGE)
    @Pattern(regexp = "^\\+?\\d{1,13}$", message = PHONE_NUMBER_ERROR_MESSAGE)
    private String phoneNumber;
}
