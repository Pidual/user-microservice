package com.emazon.usermicroservice.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements UserDetails {

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

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false) //is this a number i think
    private RoleEntity role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return authorities;
    }

    @Override
    public String getUsername() { //el identifgicador de uno usa
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
