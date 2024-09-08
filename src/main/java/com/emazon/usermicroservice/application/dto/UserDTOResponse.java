package com.emazon.usermicroservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOResponse {
    private Long id;
    private String name;
    private String lastName;
    private String documentId;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String role;
}