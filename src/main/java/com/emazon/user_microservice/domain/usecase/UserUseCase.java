package com.emazon.user_microservice.domain.usecase;

import com.emazon.user_microservice.domain.api.IUserServicePort;
import com.emazon.user_microservice.domain.exceptions.UserAlreadyExistsException;
import com.emazon.user_microservice.domain.model.User;
import com.emazon.user_microservice.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userJpaAdapter;


    public UserUseCase(IUserPersistencePort userJpaAdapter) {
        this.userJpaAdapter = userJpaAdapter;
    }

    @Override
    public void saveUser(User user) {
        validateUser(user);
        if(userJpaAdapter.getUser(user.getDocumentId()) != null){
            throw new UserAlreadyExistsException();
        }
        userJpaAdapter.saveUser(user);
    }

    private void validateUser(User user) {
        //TODO
    }
}
