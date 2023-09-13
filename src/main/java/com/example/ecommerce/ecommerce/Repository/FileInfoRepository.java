package com.example.ecommerce.ecommerce.Repository;


import com.example.ecommerce.ecommerce.Entity.Products;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends MongoRepository<Products, ObjectId> {
}
