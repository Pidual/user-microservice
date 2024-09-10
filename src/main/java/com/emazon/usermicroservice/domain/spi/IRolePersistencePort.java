package com.emazon.usermicroservice.domain.spi;

import com.emazon.usermicroservice.domain.model.Role;

public interface IRolePersistencePort {

    Role getRoleById(Long roleId);
}
