package com.example.ecommerce.ecommerce.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
@Document(collection = "Order")
public class Order {
    @MongoId
    private ObjectId id;

    @ManyToOne
    private UserInfo user;

    private List<OrderItem> orderItems;

    private double totalAmount;

    private LocalDateTime orderDate;

    // Other fields and getters/setters
}
