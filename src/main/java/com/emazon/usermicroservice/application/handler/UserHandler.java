package com.emazon.usermicroservice.application.handler;


import com.emazon.usermicroservice.application.dto.UserDTORequest;
import com.emazon.usermicroservice.application.mapper.UserRequestMapper;
import com.emazon.usermicroservice.application.mapper.UserResponseMapper;
import com.emazon.usermicroservice.domain.api.IUserServicePort;
import com.emazon.usermicroservice.domain.model.RoleEnum;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.infrastructure.output.jpa.repository.IUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userUseCase; //
    private final IUserRepository userRepository;

    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper; // DE user a UserResponse
    private final BCryptPasswordEncoder passwordEncoder;


    public void saveUser(UserDTORequest request) {
        User user = userRequestMapper.toUser(request);

        // Encrypt password here
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Convert the role string to RoleEnum
        try {
            RoleEnum roleEnum = RoleEnum.valueOf(request.getRoleName().toUpperCase());
            user.setRole(roleEnum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role: " + request.getRoleName());
        }

        userUseCase.saveUser(user);
    }

}
