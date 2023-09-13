package com.example.ecommerce.ecommerce.Entity;

import lombok.*;
import org.bson.types.ObjectId;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OrderImage {
    private ObjectId id;

    private String FileName;

    private String contentType;

    private byte[] fileData;
}
