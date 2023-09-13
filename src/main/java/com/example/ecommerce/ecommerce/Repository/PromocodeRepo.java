package com.example.ecommerce.ecommerce.Repository;

import com.example.ecommerce.ecommerce.Entity.Coupon;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocodeRepo extends MongoRepository<Coupon, ObjectId> {
    @Query("{ '_id' : ?0 }")
    Coupon getCouponById(ObjectId id);
    @Query("{ '_id' : ?0 }")
    Coupon findById(String id);
    @Query("{ 'couponCode' : ?0 }")
    Coupon findByCouponCode(String couponCode);
    @Query("{ 'discountPercentage' : ?0 }")
    Coupon getDiscountPercentage(Integer discountPercentage);
}
