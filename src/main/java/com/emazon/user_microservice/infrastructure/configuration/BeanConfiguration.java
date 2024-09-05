package com.emazon.user_microservice.infrastructure.configuration;


import com.emazon.user_microservice.domain.api.IUserServicePort;
import com.emazon.user_microservice.domain.spi.IUserPersistencePort;
import com.emazon.user_microservice.domain.usecase.UserUseCase;
import com.emazon.user_microservice.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.emazon.user_microservice.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.emazon.user_microservice.infrastructure.output.jpa.repository.IUserRepository;
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
