package com.example.ecommerce.ecommerce.Repository;

import com.example.ecommerce.ecommerce.Entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepository extends MongoRepository<Order, String> {
}
