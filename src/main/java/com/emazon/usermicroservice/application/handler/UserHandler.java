package com.emazon.usermicroservice.application.handler;

import com.emazon.usermicroservice.application.dto.UserDTORequest;
import com.emazon.usermicroservice.application.dto.UserDTOResponse;
import com.emazon.usermicroservice.application.mapper.UserRequestMapper;
import com.emazon.usermicroservice.application.mapper.UserResponseMapper;
import com.emazon.usermicroservice.domain.api.IUserServicePort;
import com.emazon.usermicroservice.domain.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional

/**
 * Esta clase comunica las capas de dominio y base de datos
 * y retorna de base de datos a el restController
 */
public class UserHandler implements IUserHandler{

    private final IUserServicePort userUseCase;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper; // DE user a UserResponse


    @Override
    public void saveUser(UserDTORequest userDTORequest) {
        User user = userRequestMapper.toUser(userDTORequest);
        userUseCase.saveUser(user); // <--- useCase = domain
    }

    @Override
    public UserDTOResponse getUser(Long documentId) {
        // Obtener el usuario desde el caso de uso (dominio)
        User user = userUseCase.getUserByDocumentId(documentId);
        // Mapear el modelo de dominio User a UserDTOResponse
        return userResponseMapper.toResponse(user);
    }

    @Override
    public List<UserDTOResponse> getAllUsers() {
        /
        List<User> users = userUseCase.getAllUsers();

        return users.stream().map(userResponseMapper::toResponse).collect(Collectors.toList());
    }
}
