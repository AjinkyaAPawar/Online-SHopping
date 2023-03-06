package com.pratiti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratiti.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
