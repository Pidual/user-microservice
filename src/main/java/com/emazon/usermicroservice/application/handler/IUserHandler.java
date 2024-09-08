package com.emazon.usermicroservice.application.handler;

import com.emazon.usermicroservice.application.dto.UserDTORequest;



public interface IUserHandler {

    void saveUser(UserDTORequest user);

}
