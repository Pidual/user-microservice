package com.emazon.user_microservice.infrastructure.output.jpa.repository;

import com.emazon.user_microservice.domain.model.User;
import com.emazon.user_microservice.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByDocumentId(Long documentId);


}
