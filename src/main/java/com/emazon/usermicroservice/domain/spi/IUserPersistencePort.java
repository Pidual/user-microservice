package com.emazon.usermicroservice.domain.spi;

import com.emazon.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {

    void saveUser(User user);

    User getUser(String documentId);


}
