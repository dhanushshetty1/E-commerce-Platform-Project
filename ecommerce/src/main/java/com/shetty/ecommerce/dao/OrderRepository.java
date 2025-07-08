package com.shetty.ecommerce.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.shetty.ecommerce.Entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}