package com.emazon.usermicroservice.infrastructure.output.jpa.entity;

import com.emazon.usermicroservice.domain.model.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    @Column(name="lastName", nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 20)
    private String documentId; // String to handle leading zeros or any format

    @Column(nullable = false, length = 13)
    private String phoneNumber; // Phone numbers with a maximum of 13 characters and possible "+" symbol

    @Column(nullable = false)
    private LocalDate birthDate; // To calculate age and validate if the user is an adult

    @Column(nullable = false, unique = true, length = 100)
    private String email; // Validate email format

    @Column(nullable = false)
    private String password; // Encrypted with bcrypt when stored

    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum; // Assign the "aux_bodega" role
}
