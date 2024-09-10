package com.emazon.usermicroservice.infrastructure.security.service;

import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserPersistencePort userJpaAdapter;

    public CustomUserDetailsService(IUserPersistencePort userJpaAdapter) {
        this.userJpaAdapter = userJpaAdapter;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Manejar el caso cuando el usuario no es encontrado
        User user = userJpaAdapter.getUserByEmail(email);

        // Asegúrate de que el rol está bien formateado y almacenado correctamente en la base de datos
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())  // Contraseña cifrada
                .roles(user.getRole().getRoleName())  // Asignar roles correctamente
                .build();
    }
}

