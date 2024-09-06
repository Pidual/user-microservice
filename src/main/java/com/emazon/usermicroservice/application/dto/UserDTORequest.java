package com.emazon.usermicroservice.application.dto;

import com.emazon.usermicroservice.domain.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern; // Importa esta clase en lugar de la de Hibernate
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 *  private String name;
 *     private String lastName; 2
 *     private String documentId;
 *     private String phoneNumber; 4
 *     private LocalDate birthDate;
 *     private String password; 6
 *     private String email;
 *     private Role role 8
 */
public class UserDTORequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @NotNull(message = "El documento de identidad es obligatorio")
    private Long documentId;

    @NotBlank(message = "El número de celular es obligatorio")
    @Pattern(regexp = "\\+\\d{1,3}\\d{10}", message = "El celular debe tener un formato válido. Ejemplo: +521234567890")
    private String phoneNumber;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate birthDate;

    @NotBlank(message = "La clave es obligatoria")
    private String password;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String email;

    @NotBlank( message = "el Id del rol no peude estar vacio")
    private Long idRole;

}
