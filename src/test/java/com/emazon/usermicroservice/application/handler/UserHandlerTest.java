package com.emazon.usermicroservice.application.handler;

import com.emazon.usermicroservice.application.dto.UserDTORequest;
import com.emazon.usermicroservice.application.mapper.UserRequestMapper;
import com.emazon.usermicroservice.domain.api.IRoleServicePort;
import com.emazon.usermicroservice.domain.api.IUserServicePort;
import com.emazon.usermicroservice.domain.model.Role;
import com.emazon.usermicroservice.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.*;

class UserHandlerTest {

    @Mock
    private IUserServicePort userUseCase;

    @Mock
    private IRoleServicePort roleUseCase;

    @Mock
    private UserRequestMapper userRequestMapper;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserHandler userHandler;

    private UserDTORequest userDTORequest;
    private User user;
    private Role role;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample data for testing
        userDTORequest = new UserDTORequest();
        userDTORequest.setFirstName("John");
        userDTORequest.setLastName("Doe");
        userDTORequest.setDocumentId("123456789");
        userDTORequest.setPhoneNumber("+573001234567");
        userDTORequest.setBirthDate(java.time.LocalDate.of(1990, 1, 1));
        userDTORequest.setEmail("john.doe@example.com");
        userDTORequest.setPassword("password123");

        role = new Role();
        role.setRoleId(2L);
        role.setRoleName("AUX_BODEGA");

        user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setRole(role);

        when(userRequestMapper.toUser(userDTORequest)).thenReturn(user);
        when(roleUseCase.getRole(2L)).thenReturn(role);
        when(passwordEncoder.encode("password123")).thenReturn("encryptedPassword123");
    }

    @Test
    void testSaveUser() {
        // Act
        userHandler.saveAuxBodega(userDTORequest);

        // Assert that the password was encrypted
        verify(passwordEncoder).encode("password123");

        // Assert that the role was retrieved from roleUseCase
        verify(roleUseCase).getRole(2L);

        // Assert that the user was saved
        verify(userUseCase).saveUser(user);

        // Ensure that the user object now has the encrypted password
        assert(user.getPassword().equals("encryptedPassword123"));
    }
}
