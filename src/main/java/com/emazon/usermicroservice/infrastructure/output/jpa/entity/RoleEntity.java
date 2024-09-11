package com.emazon.usermicroservice.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long roleId;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String roleName;

    @Column(name = "description", length = 150)
    private String roleDescription;


}
