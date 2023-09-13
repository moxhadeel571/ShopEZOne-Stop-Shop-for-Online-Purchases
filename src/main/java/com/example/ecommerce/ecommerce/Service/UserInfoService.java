package com.example.ecommerce.ecommerce.Service;

import com.example.ecommerce.ecommerce.Entity.UserInfo;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface UserInfoService {
    void saveCheckout(UserInfo userInfo);


}
