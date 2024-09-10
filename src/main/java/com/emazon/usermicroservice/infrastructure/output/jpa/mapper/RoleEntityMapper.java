package com.emazon.usermicroservice.infrastructure.output.jpa.mapper;

import com.emazon.usermicroservice.domain.model.Role;
import com.emazon.usermicroservice.infrastructure.output.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    Role toRole(RoleEntity roleEntity);

    RoleEntity toEntity(Role role);

}