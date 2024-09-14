package com.emazon.usermicroservice.domain.usecase;

import com.emazon.usermicroservice.domain.exceptions.RoleNotFoundException;
import com.emazon.usermicroservice.domain.model.Role;
import com.emazon.usermicroservice.domain.spi.IRolePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleUseCaseTest {

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @InjectMocks
    private RoleUseCase roleUseCase;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRole_WhenRoleExists() {
        // Given
        Long roleId = 1L;
        Role role = new Role();
        role.setRoleId(roleId);
        role.setRoleName("ADMIN");

        // Simulamos el comportamiento del método del puerto de persistencia
        when(rolePersistencePort.getRoleById(roleId)).thenReturn(role);

        // Act
        Role result = roleUseCase.getRole(roleId);

        // Assert
        assertNotNull(result);
        assertEquals(roleId, result.getRoleId());
        assertEquals("ADMIN", result.getRoleName());

        // Verificamos que el puerto de persistencia fue llamado
        verify(rolePersistencePort, times(1)).getRoleById(roleId);
    }

    @Test
    void testGetRole_WhenRoleDoesNotExist() {
        // Given
        Long invalidRoleId = 4L;

        // Simulamos el comportamiento cuando no existe el rol
        when(rolePersistencePort.getRoleById(invalidRoleId)).thenReturn(null);

        // Act & Assert
        assertThrows(RoleNotFoundException.class, () -> {roleUseCase.getRole(invalidRoleId);});

        // Verificamos que el puerto de persistencia fue llamado
        verify(rolePersistencePort, times(1)).getRoleById(invalidRoleId);
    }
}