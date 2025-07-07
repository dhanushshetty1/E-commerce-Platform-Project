package com.shetty.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shetty.ecommerce.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
