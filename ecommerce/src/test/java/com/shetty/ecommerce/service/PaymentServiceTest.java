package com.shetty.ecommerce.service;

import com.shetty.ecommerce.Entities.Order;
import com.shetty.ecommerce.Entities.Payment;
import com.shetty.ecommerce.dao.OrderRepository;
import com.shetty.ecommerce.dao.PaymentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private PaymentService paymentService;

    private Order mockOrder;
    private Payment mockPayment;

    @BeforeEach
    void setUp() {
        mockOrder = new Order();
        mockOrder.setId(1L);
        mockOrder.setTotalAmount(999.99);

        mockPayment = new Payment();
        mockPayment.setId(100L);
        mockPayment.setOrder(mockOrder);
        mockPayment.setAmount(999.99);
        mockPayment.setStatus("SUCCESS");
    }

    @Test
    void testProcessPayment_Success() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(mockOrder));
        when(paymentRepository.save(any(Payment.class))).thenReturn(mockPayment);

        Payment result = paymentService.processPayment(1L);

        assertNotNull(result);
        assertEquals("SUCCESS", result.getStatus());
        assertEquals(mockOrder, result.getOrder());
        assertEquals(999.99, result.getAmount(), 0.01);
        verify(orderRepository).findById(1L);
        verify(paymentRepository).save(any(Payment.class));
    }

    @Test
    void testProcessPayment_OrderNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        Payment result = paymentService.processPayment(99L);

        assertNull(result);
        verify(orderRepository).findById(99L);
        verify(paymentRepository, never()).save(any(Payment.class));
    }
}
