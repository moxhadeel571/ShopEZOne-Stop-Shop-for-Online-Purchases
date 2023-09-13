package com.example.ecommerce.ecommerce.Entity;

import lombok.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserInfo  {
    @MongoId
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String Username;
    private String email;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String city;
    private String state;
    private String zipcode;



}
