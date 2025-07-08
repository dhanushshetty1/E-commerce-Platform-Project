package com.shetty.ecommerce.controller;

import com.shetty.ecommerce.Entities.Order;
import com.shetty.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        logger.info("✅ User/Admin requested all orders.");
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        logger.info("✅ User/Admin requested order with ID: {}", id);
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        logger.info("🛒 User ID {} is placing an order with {} product(s)", 
                    order.getUser() != null ? order.getUser().getId() : "Unknown",
                    order.getProducts() != null ? order.getProducts().size() : 0);
        return orderService.placeOrder(order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        logger.warn("⚠️ Admin is deleting order with ID: {}", id);
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }
}
