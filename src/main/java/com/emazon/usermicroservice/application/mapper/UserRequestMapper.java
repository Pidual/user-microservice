
package com.emazon.usermicroservice.application.mapper;

import com.emazon.usermicroservice.application.dto.UserDTORequest;
import com.emazon.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    User toUser(UserDTORequest userDTORequest);

}
