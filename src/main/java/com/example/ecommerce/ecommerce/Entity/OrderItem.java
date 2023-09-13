package com.example.ecommerce.ecommerce.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.ManyToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
@Document(collection = "OrderItem")
public class OrderItem {
    @MongoId
    private String id;
    private Products product;
    private List<String> productName;
    private int quantity;
    private Coupon coupon;
    private double price;
    private double totalPrice;
    public OrderItem(Products product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    // Other fields and getters/setters
}