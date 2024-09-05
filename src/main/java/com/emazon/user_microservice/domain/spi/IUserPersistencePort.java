package com.emazon.user_microservice.domain.spi;

import com.emazon.user_microservice.domain.model.User;

public interface IUserPersistencePort {

    void saveUser(User user);

    User getUser(Long documentId);
}
