package com.emazon.user_microservice.application.handler;

import com.emazon.user_microservice.application.dto.UserDTORequest;
import com.emazon.user_microservice.domain.api.IUserServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class userHandler implements IUserHandler{

    private final IUserServicePort userUseCase;



    @Override
    public void saveUser(UserDTORequest user) {

    }

    @Override
    public UserDTORequest getUser(String id) {
        return null;
    }
}
