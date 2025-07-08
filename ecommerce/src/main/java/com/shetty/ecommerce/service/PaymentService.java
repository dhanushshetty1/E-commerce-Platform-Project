package com.shetty.ecommerce.service;

import com.shetty.ecommerce.Entities.Order;
import com.shetty.ecommerce.Entities.Payment;
import com.shetty.ecommerce.dao.OrderRepository;
import com.shetty.ecommerce.dao.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Payment processPayment(Long orderId) {
        logger.info("💳 Processing payment for Order ID: {}", orderId);

        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            logger.error("❌ Order ID {} not found. Payment failed.", orderId);
            return null;
        }

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(order.getTotalAmount());
        payment.setStatus("SUCCESS");  // Simulate successful payment
        payment.setPaymentDate(LocalDateTime.now());

        Payment savedPayment = paymentRepository.save(payment);
        logger.info("✅ Payment processed successfully for Order ID: {} with amount ₹{}", orderId, payment.getAmount());

        return savedPayment;
    }
}
