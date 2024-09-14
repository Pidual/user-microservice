package com.emazon.usermicroservice.infrastructure.configuration;


import com.emazon.usermicroservice.domain.api.IRoleServicePort;
import com.emazon.usermicroservice.domain.api.IUserServicePort;
import com.emazon.usermicroservice.domain.spi.IRolePersistencePort;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;
import com.emazon.usermicroservice.domain.usecase.RoleUseCase;
import com.emazon.usermicroservice.domain.usecase.UserUseCase;
import com.emazon.usermicroservice.infrastructure.output.jpa.adapter.RoleJpaAdapter;
import com.emazon.usermicroservice.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.emazon.usermicroservice.infrastructure.output.jpa.mapper.RoleEntityMapper;
import com.emazon.usermicroservice.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.emazon.usermicroservice.infrastructure.output.jpa.repository.RoleRepository;
import com.emazon.usermicroservice.infrastructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;
    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleJpaAdapter(roleRepository, roleEntityMapper);
    }


    @Bean
    public UserUseCase userUseCase() {
        return new UserUseCase(userPersistencePort());
    }


}
