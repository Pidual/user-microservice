package com.emazon.usermicroservice.domain.api;

import com.emazon.usermicroservice.domain.model.Role;


public interface IRoleServicePort {

    Role getRole(Long roleId);
}
