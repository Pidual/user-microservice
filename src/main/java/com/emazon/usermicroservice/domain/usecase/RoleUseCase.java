package com.emazon.usermicroservice.domain.usecase;

import com.emazon.usermicroservice.domain.api.IRoleServicePort;
import com.emazon.usermicroservice.domain.exceptions.RoleNotFoundException;
import com.emazon.usermicroservice.domain.model.Role;
import com.emazon.usermicroservice.domain.spi.IRolePersistencePort;

import static com.emazon.usermicroservice.common.Constants.ROL_NOT_FOUND_ERROR_MESSAGE;


public class RoleUseCase implements IRoleServicePort {



    private final IRolePersistencePort roleJpaAdapter;

    public RoleUseCase(IRolePersistencePort roleJpaAdapter) {
        this.roleJpaAdapter = roleJpaAdapter;
    }

    @Override
    public Role getRole(Long roleId) {
        Role role = roleJpaAdapter.getRoleById(roleId);
        if(role == null) {
            throw new RoleNotFoundException(ROL_NOT_FOUND_ERROR_MESSAGE);
        }
        return role;
    }
}
