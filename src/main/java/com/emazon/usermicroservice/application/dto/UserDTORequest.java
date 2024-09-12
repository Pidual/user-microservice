package com.emazon.usermicroservice.application.dto;

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
public class UserDTORequest {

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String firstName;

    @NotBlank(message = "El apellido no puede estar vacío.")
    private String lastName;

    @NotBlank(message = "El documento de identidad no puede estar vacío.")
    @Pattern(regexp = "\\d+", message = "El documento de identidad debe ser numérico.")
    private String documentId;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía.")
    @Past(message = "La fecha de nacimiento debe ser en el pasado.")
    private LocalDate birthDate;

    @NotBlank(message = "El correo no puede estar vacío.")
    @Email(message = "Debe proporcionar un correo electrónico válido.")
    private String email;

    @NotBlank(message = EMPTY_PASSWORD_ERROR_MESSAGE)
    private String password;

    @NotBlank(message = PHONE_NUMBER_ERROR_MESSAGE)
    @Pattern(regexp = "^\\+?\\d{1,13}$", message = PHONE_NUMBER_ERROR_MESSAGE)
    private String phoneNumber;

    @NotNull(message = EMPTY_ROL_ERROR_MESSAGE)
    private Long roleId;
}
