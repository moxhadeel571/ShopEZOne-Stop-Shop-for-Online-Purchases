package com.example.ecommerce.ecommerce.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
@Document(collection = "shipments")
public class Shipment {
    @Id
    private String id;
    private String orderId;
    private String trackingNumber;
    private List<String> productNames;
    private String carrier;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Define the date format here
    private Date estimatedDelivery;
    private String status;
    private String deliveryAddress;
    // Other shipment-related fields, getters, and setters
}
