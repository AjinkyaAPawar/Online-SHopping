package com.pratiti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratiti.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
