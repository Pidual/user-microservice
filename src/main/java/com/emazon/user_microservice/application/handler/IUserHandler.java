package com.emazon.user_microservice.application.handler;

import com.emazon.user_microservice.application.dto.UserDTORequest;

public interface IUserHandler {

    void saveUser(UserDTORequest user);

    UserDTORequest getUser(String id);

}
