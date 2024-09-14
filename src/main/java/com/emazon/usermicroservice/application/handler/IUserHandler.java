package com.emazon.usermicroservice.application.handler;

import com.emazon.usermicroservice.application.dto.UserDTORequest;



public interface IUserHandler {

    void saveAuxBodega(UserDTORequest user);

    void saveClient(UserDTORequest request);
}
