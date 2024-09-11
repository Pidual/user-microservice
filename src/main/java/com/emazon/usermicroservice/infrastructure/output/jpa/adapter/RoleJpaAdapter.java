package com.emazon.usermicroservice.infrastructure.output.jpa.adapter;

import com.emazon.usermicroservice.domain.model.Role;
import com.emazon.usermicroservice.domain.spi.IRolePersistencePort;
import com.emazon.usermicroservice.infrastructure.output.jpa.mapper.RoleEntityMapper;
import com.emazon.usermicroservice.infrastructure.output.jpa.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;


    @Override
    public Role getRoleById(Long roleId) {
        return roleEntityMapper.toRole(roleRepository.findRoleEntityByRoleId(roleId));
    }
}
