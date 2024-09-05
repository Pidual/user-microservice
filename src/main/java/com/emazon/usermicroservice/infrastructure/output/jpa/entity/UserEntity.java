package com.emazon.usermicroservice.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 20)
    private Long documentId; // String to handle leading zeros or any format

    @Column(nullable = false, length = 13)
    private String phoneNumber; // Phone numbers with a maximum of 13 characters and possible "+" symbol

    @Column(nullable = false)
    private LocalDate birthDate; // To calculate age and validate if the user is an adult

    @Column(nullable = false, unique = true, length = 100)
    private String email; // Validate email format

    @Column(nullable = false)
    private String password; // Encrypted with bcrypt when stored

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role; // Assign the "aux_bodega" role

}
