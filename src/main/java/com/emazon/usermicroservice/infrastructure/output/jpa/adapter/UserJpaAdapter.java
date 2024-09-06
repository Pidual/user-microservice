package com.emazon.usermicroservice.infrastructure.output.jpa.adapter;

import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;
import com.emazon.usermicroservice.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.emazon.usermicroservice.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


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

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(userEntityMapper::toUser).toList();
    }


}
