package com.emazon.user_microservice.application.mapper;


import com.emazon.user_microservice.application.dto.UserDTORequest;
import com.emazon.user_microservice.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    User toUser(UserDTORequest userDTORequest);

    UserDTORequest toUserDTO(User user);

}
