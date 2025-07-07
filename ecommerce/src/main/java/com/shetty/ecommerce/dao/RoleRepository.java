package com.shetty.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shetty.ecommerce.Entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>  {

}