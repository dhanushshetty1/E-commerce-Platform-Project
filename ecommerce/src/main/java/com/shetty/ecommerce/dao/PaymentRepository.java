package com.shetty.ecommerce.dao;

import com.shetty.ecommerce.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
