package com.emazon.usermicroservice.infrastructure.output.jpa.adapter;

import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;
import com.emazon.usermicroservice.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.emazon.usermicroservice.infrastructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public User getUserByEmail(String email) {
        return userEntityMapper.toUser(userRepository.findByEmail(email)); //HAHAHAH 👀
    }


}
