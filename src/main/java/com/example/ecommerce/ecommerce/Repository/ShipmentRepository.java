package com.example.ecommerce.ecommerce.Repository;

import com.example.ecommerce.ecommerce.Entity.Shipment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends MongoRepository<Shipment, String> {
    @Query("{ '_id' : ?0 }")
    Shipment findAllByShipmentId(ObjectId id);
    // Custom query methods can be added here
}
