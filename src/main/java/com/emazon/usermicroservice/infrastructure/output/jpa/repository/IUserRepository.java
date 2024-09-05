package com.emazon.usermicroservice.infrastructure.output.jpa.repository;

import com.emazon.usermicroservice.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByDocumentId(Long documentId);


}
