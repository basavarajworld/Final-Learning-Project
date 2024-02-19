package com.Basavaraj.learningportalnew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Basavaraj.learningportalnew.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
