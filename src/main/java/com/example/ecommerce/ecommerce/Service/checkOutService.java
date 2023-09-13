package com.example.ecommerce.ecommerce.Service;

import com.example.ecommerce.ecommerce.Entity.UserInfo;
import com.example.ecommerce.ecommerce.Entity.checkOut;
import org.bson.types.ObjectId;

import java.util.List;
public interface checkOutService {

    String processOrder(ObjectId id);
    List<checkOut>  getAllCustomers();
    checkOut saveCheckout(checkOut checkOut, UserInfo userInfo) throws Exception;

    checkOut getAllCustomers(ObjectId id);

}
