package com.pratiti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratiti.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
