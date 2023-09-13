package com.example.ecommerce.ecommerce.Repository;

import com.example.ecommerce.ecommerce.Entity.OrderReturn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderReturnRepository extends MongoRepository<OrderReturn, String> {
    @Query("{ '_id' : ?0 }")
    Optional<OrderReturn> findByReturnId(String id);
    // You can define custom queries or methods here if needed
}
