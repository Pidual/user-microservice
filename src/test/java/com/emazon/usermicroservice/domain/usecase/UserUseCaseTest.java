package com.emazon.usermicroservice.domain.usecase;


import com.emazon.usermicroservice.domain.exceptions.UnderageException;
import com.emazon.usermicroservice.domain.exceptions.WrongEmailException;
import com.emazon.usermicroservice.domain.exceptions.WrongPhoneNumberException;
import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static com.emazon.usermicroservice.common.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userJpaAdapter;

    @InjectMocks
    private UserUseCase userUseCase;

    private User user;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Datos válidos de ejemplo
        user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setDocumentId("1234567890");
        user.setPhoneNumber("+573001234567");
        user.setBirthDate(LocalDate.of(1990, 1, 1));  // Adult
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
    }

    @Test
    void testSaveUser_WithValidData_ShouldPass() {
        // Act
        userUseCase.saveUser(user);

        // Assert
        verify(userJpaAdapter, times(1)).saveUser(user);
    }

    @Test
    void testSaveUser_WithInvalidPhoneNumber_ShouldThrowException() {
        // Setup invalid phone number
        user.setPhoneNumber("300123456");  // No "+" y no tiene 13 caracteres

        // Act & Assert
        WrongPhoneNumberException exception = assertThrows(WrongPhoneNumberException.class, () -> {
            userUseCase.saveUser(user);
        });

        assertEquals(PHONE_NUMBER_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void testSaveUser_WithUnderageUser_ShouldThrowException() {
        // Setup birthdate for a user under 18
        user.setBirthDate(LocalDate.now().minusYears(15));  // 15 años

        // Act & Assert
        UnderageException exception = assertThrows(UnderageException.class, () -> {
            userUseCase.saveUser(user);
        });

        assertEquals(UNDERAGE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void testSaveUser_WithInvalidEmail_ShouldThrowException() {
        // Setup invalid email
        user.setEmail("john.doe.com");  // Email sin "@"

        // Act & Assert
        WrongEmailException exception = assertThrows(WrongEmailException.class, () -> {
            userUseCase.saveUser(user);});

        assertEquals(WRONG_EMAIL_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void testSaveUser_WithEmptyPassword_ShouldThrowException() {
        // Setup empty password
        user.setPassword("");  // Contraseña vacía
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userUseCase.saveUser(user);
        });
        // Añadir lógica personalizada si tienes una excepción para contraseñas vacías
        assertEquals(EMPTY_PASSWORD_ERROR_MESSAGE, exception.getMessage());
    }
}