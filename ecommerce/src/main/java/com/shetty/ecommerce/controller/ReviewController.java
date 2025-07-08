package com.shetty.ecommerce.controller;

import com.shetty.ecommerce.Entities.Product;
import com.shetty.ecommerce.Entities.Review;
import com.shetty.ecommerce.Entities.User;
import com.shetty.ecommerce.dao.ProductRepository;
import com.shetty.ecommerce.dao.ReviewRepository;
import com.shetty.ecommerce.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class ReviewController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {

        Product product = productRepository.findById(review.getProduct().getId()).orElse(null);
        review.setProduct(product);

        User user = userRepository.findById(review.getUser().getId()).orElse(null);
        review.setUser(user);

        logger.info("📝 User ID {} submitted review for Product ID {} with rating {}", 
                    user != null ? user.getId() : "Unknown", 
                    product != null ? product.getId() : "Unknown", 
                    review.getRating());

        return reviewRepository.save(review);
    }

    @GetMapping("/reviews/product/{productId}")
    public List<Review> getReviewsByProduct(@PathVariable Long productId) {
        logger.info("👤 Fetching reviews for Product ID {}", productId);
        return reviewRepository.findAll().stream()
                .filter(r -> r.getProduct().getId().equals(productId))
                .toList();
    }
}
