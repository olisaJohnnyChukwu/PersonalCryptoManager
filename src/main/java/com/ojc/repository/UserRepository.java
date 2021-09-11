package com.ojc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojc.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);

}
