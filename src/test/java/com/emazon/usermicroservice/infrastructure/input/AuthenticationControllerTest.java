package com.emazon.usermicroservice.infrastructure.input;

import com.emazon.usermicroservice.application.dto.AuthenticationRequest;
import com.emazon.usermicroservice.application.dto.AuthenticationResponse;
import com.emazon.usermicroservice.infrastructure.security.service.AuthenticationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationControllerTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLogin_WithValidCredentials_ShouldReturnJwt() {
        // Given
        AuthenticationRequest authRequest = new AuthenticationRequest("carlosmapache1@gmail.com", "password123");
        AuthenticationResponse expectedResponse = new AuthenticationResponse("valid-jwt-token");

        // Simulamos la respuesta de autenticación exitosa
        when(authenticationService.login(authRequest)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<AuthenticationResponse> response = authenticationController.login(authRequest);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());

        // Verificamos que el servicio de autenticación fue llamado una vez
        verify(authenticationService, times(1)).login(authRequest);
    }

    @Test
    void testLogin_WithInvalidCredentials_ShouldThrowException() {
        // Given
        AuthenticationRequest authRequest = new AuthenticationRequest("invalid.email@gmail.com", "wrongpassword");

        // Simulamos una excepción lanzada por el servicio de autenticación para credenciales incorrectas
        when(authenticationService.login(authRequest)).thenThrow(new RuntimeException("Invalid credentials"));

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authenticationController.login(authRequest);
        });

        assertEquals("Invalid credentials", exception.getMessage());

        // Verificamos que el servicio de autenticación fue llamado una vez
        verify(authenticationService, times(1)).login(authRequest);
    }
}