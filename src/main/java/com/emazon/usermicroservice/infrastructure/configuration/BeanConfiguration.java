package com.emazon.usermicroservice.infrastructure.configuration;


import com.emazon.usermicroservice.domain.api.IUserServicePort;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;
import com.emazon.usermicroservice.domain.usecase.UserUseCase;
import com.emazon.usermicroservice.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.emazon.usermicroservice.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.emazon.usermicroservice.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

}
