package com.emazon.usermicroservice.domain.api;

import com.emazon.usermicroservice.domain.model.User;

public interface IUserServicePort {

    void saveUser(User user);

    User getUserByEmail(String email);

}
