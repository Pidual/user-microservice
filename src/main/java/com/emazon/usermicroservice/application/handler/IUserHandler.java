package com.emazon.usermicroservice.application.handler;

import com.emazon.usermicroservice.application.dto.UserDTORequest;
import com.emazon.usermicroservice.application.dto.UserDTOResponse;

import java.util.List;

public interface IUserHandler {

    void saveUser(UserDTORequest user);

    UserDTOResponse getUser(Long documentId);

    List<UserDTOResponse> getAllUsers();

}
