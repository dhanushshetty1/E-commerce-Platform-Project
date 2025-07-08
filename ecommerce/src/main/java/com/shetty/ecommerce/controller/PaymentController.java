package com.shetty.ecommerce.controller;

import com.shetty.ecommerce.Entities.Payment;
import com.shetty.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/{orderId}")
    public Payment makePayment(@PathVariable Long orderId) {
        logger.info("💳 Payment request received for Order ID: {}", orderId);
        Payment payment = paymentService.processPayment(orderId);
        logger.info("✅ Payment processed for Order ID: {} with Payment ID: {}", orderId, payment.getId());
        return payment;
    }
}
