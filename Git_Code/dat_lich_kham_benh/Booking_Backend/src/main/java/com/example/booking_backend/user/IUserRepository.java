package com.example.booking_backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);
//    boolean existsByTableNameAndFieldName(String tableName, String fieldName, Object value);
}
