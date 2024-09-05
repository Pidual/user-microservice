package com.emazon.usermicroservice.domain.spi;

import com.emazon.usermicroservice.domain.model.User;

public interface IUserPersistencePort {

    void saveUser(User user);

    User getUser(Long documentId);
}
