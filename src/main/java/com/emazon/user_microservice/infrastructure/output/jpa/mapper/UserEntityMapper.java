package com.emazon.user_microservice.infrastructure.output.jpa.mapper;


import com.emazon.user_microservice.domain.model.User;
import com.emazon.user_microservice.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {RoleEntityMapper.class})
public interface UserEntityMapper {

    UserEntity toEntity(User user);
    User toUser(UserEntity userEntity);



}
