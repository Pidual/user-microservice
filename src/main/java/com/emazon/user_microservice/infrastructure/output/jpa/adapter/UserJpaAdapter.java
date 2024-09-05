package com.emazon.user_microservice.infrastructure.output.jpa.adapter;

import com.emazon.user_microservice.domain.model.User;
import com.emazon.user_microservice.domain.spi.IUserPersistencePort;
import com.emazon.user_microservice.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.emazon.user_microservice.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;


    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public User getUser(Long documentId) {
        return userEntityMapper.toUser(userRepository.findByDocumentId(documentId));
    }


}
