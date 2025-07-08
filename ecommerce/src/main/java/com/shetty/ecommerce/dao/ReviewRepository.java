package com.shetty.ecommerce.dao;

import com.shetty.ecommerce.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
