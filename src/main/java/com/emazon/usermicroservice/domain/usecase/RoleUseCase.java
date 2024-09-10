package com.emazon.usermicroservice.domain.usecase;

import com.emazon.usermicroservice.domain.api.IRoleServicePort;
import com.emazon.usermicroservice.domain.model.Role;
import com.emazon.usermicroservice.domain.spi.IRolePersistencePort;


public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort roleJpaAdapter;

    public RoleUseCase(IRolePersistencePort roleJpaAdapter) {
        this.roleJpaAdapter = roleJpaAdapter;
    }

    @Override
    public Role getRole(Long roleId) {
        return roleJpaAdapter.getRoleById(roleId);
    }
}
