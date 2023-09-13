package com.example.ecommerce.ecommerce.Repository;

import com.example.ecommerce.ecommerce.Entity.UserInfo;
import com.example.ecommerce.ecommerce.Entity.checkOut;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface checkOutRepository extends MongoRepository<checkOut, ObjectId> {
    @Query("{ 'user' : ?0 }")
    checkOut findByUser(UserInfo user);
    @Query("{ '_id' : ?0 }")
    Optional<Object> findById(String id);
}
