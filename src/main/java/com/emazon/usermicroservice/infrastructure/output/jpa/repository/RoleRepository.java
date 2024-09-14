package com.emazon.usermicroservice.infrastructure.output.jpa.repository;

import com.emazon.usermicroservice.infrastructure.output.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findRoleEntityByRoleId(Long roleId);

}
