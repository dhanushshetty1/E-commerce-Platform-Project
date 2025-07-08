package com.shetty.ecommerce.service;

import com.shetty.ecommerce.Entities.Order;
import com.shetty.ecommerce.Entities.Product;
import com.shetty.ecommerce.Entities.User;
import com.shetty.ecommerce.dao.OrderRepository;
import com.shetty.ecommerce.dao.ProductRepository;
import com.shetty.ecommerce.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getAllOrders() {
        logger.info("📦 Fetching all orders from database");
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        logger.info("🔍 Fetching order with ID: {}", id);
        return orderRepository.findById(id).orElse(null);
    }

    public Order placeOrder(Order order) {
        logger.info("🛒 Placing new order for User ID: {}", 
                    order.getUser() != null ? order.getUser().getId() : "Unknown");

        // Load User
        User user = userRepository.findById(order.getUser().getId()).orElse(null);
        order.setUser(user);

        // Load Products
        List<Product> products = order.getProducts().stream()
            .map(p -> productRepository.findById(p.getId()).orElse(null))
            .toList();

        order.setProducts(products);

        // Calculate total with discount applied
        double totalAmount = products.stream()
            .mapToDouble(p -> p.getPrice() - (p.getPrice() * p.getDiscount() / 100))
            .sum();

        order.setTotalAmount(totalAmount);

        logger.info("✅ Order placed with total amount: {}", totalAmount);

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        logger.warn("⚠️ Deleting order with ID: {}", id);
        orderRepository.deleteById(id);
    }
}
