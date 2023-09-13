    package com.example.ecommerce.ecommerce.Entity;

    import lombok.*;
    import org.bson.types.ObjectId;
    import org.springframework.data.mongodb.core.mapping.Document;
    import org.springframework.data.mongodb.core.mapping.Field;
    import org.springframework.data.mongodb.core.mapping.MongoId;
    import org.springframework.format.annotation.DateTimeFormat;

    import javax.persistence.ManyToOne;
    import javax.persistence.OneToOne;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Setter
    @Data
    @Document(collection = "products")
    public class Products{

        @MongoId
        private ObjectId id;
        private String title;
        @Field("quantity")
        private Integer quantity;
        private List<String> category; // Representing a list of selected categories
        private String description;
        private String brand;
        private String size;
        private String gender;
        private double price;
        private Integer discount;
        private String specifications;
        private String warrantyInformation;
        private String color;
        private double DiscountPercentage;
    private List<Image> images;
        @ManyToOne
        private Products product;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date orderDate; // For handling file uploads
        // Seller information fields
        private String name;
        private String address;
        private String SellerDescription;
        private String contactNumber;


        // Getters and setters for each field
        // Additional methods as needed
    }
