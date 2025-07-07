package com.shetty.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shetty.ecommerce.Entities.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
	User findByEmail(String email);
}
