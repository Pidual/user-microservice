package com.emazon.usermicroservice.domain.usecase;

import com.emazon.usermicroservice.domain.api.IUserServicePort;
import com.emazon.usermicroservice.domain.exceptions.UserAlreadyExistsException;
import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;

import java.util.List;

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

    @Override
    public User getUserByDocumentId(Long documentId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }


    private void validateUser(User user) {
        //TODO
    }
}
