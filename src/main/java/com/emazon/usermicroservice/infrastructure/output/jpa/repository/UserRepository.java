package com.emazon.usermicroservice.infrastructure.output.jpa.repository;

import com.emazon.usermicroservice.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByDocumentId(String documentId);

    UserEntity findByEmail(String email);
}
