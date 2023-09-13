package com.example.ecommerce.ecommerce.Repository;

import com.example.ecommerce.ecommerce.Entity.User;
import com.example.ecommerce.ecommerce.Entity.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo,ObjectId> {

    @Query("{ 'email' : ?0 }")
    User findByEmail(String email);
}
