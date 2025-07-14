package com.shetty.ecommerce.service;

import com.shetty.ecommerce.Entities.Order;
import com.shetty.ecommerce.Entities.Product;
import com.shetty.ecommerce.Entities.User;
import com.shetty.ecommerce.dao.OrderRepository;
import com.shetty.ecommerce.dao.ProductRepository;
import com.shetty.ecommerce.dao.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderService orderService;

    private User mockUser;
    private Product product1;
    private Product product2;
    private Order order;

    @BeforeEach
    void setUp() {
        mockUser = new User();
        mockUser.setId(1);
        mockUser.setName("John");

        product1 = new Product();
        product1.setId(1L);
        product1.setPrice(1000);
        product1.setDiscount(10); // 10% off

        product2 = new Product();
        product2.setId(2L);
        product2.setPrice(500);
        product2.setDiscount(20); // 20% off

        order = new Order();
        order.setUser(mockUser);
        order.setProducts(Arrays.asList(product1, product2));
    }

    @Test
    void testPlaceOrder() {
        when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product2));
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Order placedOrder = orderService.placeOrder(order);

        assertNotNull(placedOrder);
        assertEquals(mockUser, placedOrder.getUser());
        assertEquals(2, placedOrder.getProducts().size());

        // Expected total = 1000 - 10% = 900 + 500 - 20% = 400 => 1300
        assertEquals(1300.0, placedOrder.getTotalAmount(), 0.001);
    }
}
