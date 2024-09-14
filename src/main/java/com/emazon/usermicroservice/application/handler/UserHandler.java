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

import static com.emazon.usermicroservice.common.Constants.ROLE_AUX_BODEGA;
import static com.emazon.usermicroservice.common.Constants.ROLE_USER;


@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userUseCase;
    private final IRoleServicePort roleUseCase;
    private final UserRequestMapper userRequestMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    // 1 = admin
    // 2 = aux bodega
    // 3 = client

    public void saveAuxBodega(UserDTORequest request) {
        User user = userRequestMapper.toUser(request);
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setRole( roleUseCase.getRole(ROLE_AUX_BODEGA));
        userUseCase.saveUser(user);
    }

    public void saveClient(UserDTORequest client) {
        User user = userRequestMapper.toUser(client);
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setRole( roleUseCase.getRole(ROLE_USER));
        userUseCase.saveUser(user);
    }


}
