package com.emazon.usermicroservice.application.handler;


import com.emazon.usermicroservice.application.dto.UserDTORequest;
import com.emazon.usermicroservice.application.mapper.UserRequestMapper;
import com.emazon.usermicroservice.domain.api.IRoleServicePort;
import com.emazon.usermicroservice.domain.api.IUserServicePort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.emazon.usermicroservice.domain.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userUseCase;
    private final IRoleServicePort roleUseCase;
    private final UserRequestMapper userRequestMapper;
    private final BCryptPasswordEncoder passwordEncoder;


    public void saveUser(UserDTORequest request) {
        User user = userRequestMapper.toUser(request);
        // Encrypt password here

        String password = passwordEncoder.encode(user.getPassword());
        System.out.println(password);
        user.setPassword(password);

        user.setRole( roleUseCase.getRole(request.getRole_id()));
        userUseCase.saveUser(user);
    }



}
