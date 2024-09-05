package com.emazon.usermicroservice.application.mapper;


import com.emazon.usermicroservice.application.dto.UserDTOResponse;
import com.emazon.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserDTOResponse toResponse(User user);

}
