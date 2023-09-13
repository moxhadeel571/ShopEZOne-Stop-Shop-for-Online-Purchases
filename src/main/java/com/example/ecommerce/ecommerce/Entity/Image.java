package com.example.ecommerce.ecommerce.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Image {
    private ObjectId id;

    private String FileName;

    private String contentType;

    private byte[] fileData;
}
