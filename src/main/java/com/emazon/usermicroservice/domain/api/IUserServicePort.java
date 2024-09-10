package com.emazon.usermicroservice.domain.api;


import com.emazon.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserServicePort {

    void saveUser(User user);

    User getUserByEmail(String email);

}
