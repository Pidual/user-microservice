package com.emazon.usermicroservice.infrastructure.output.jpa.mapper;

import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;


/**
 * Importante usar el RoleEntityMapper.class para el mappeo
 */
@Mapper(componentModel = "spring", uses = {RoleEntityMapper.class})
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toUser(UserEntity userEntity);
}