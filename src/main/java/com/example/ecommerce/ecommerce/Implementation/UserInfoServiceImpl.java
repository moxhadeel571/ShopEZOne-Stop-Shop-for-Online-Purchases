package com.example.ecommerce.ecommerce.Implementation;

import com.example.ecommerce.ecommerce.Entity.UserInfo;
import com.example.ecommerce.ecommerce.Repository.UserInfoRepository;
import com.example.ecommerce.ecommerce.Service.UserInfoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoServiceImpl implements UserInfoService {
  private UserInfoRepository userInfoRepository;
@Autowired
    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public void saveCheckout(UserInfo userInfo) {

// Set user information from checkoutUser to userInfo
        userInfo.setFirstName(userInfo.getFirstName());
        userInfo.setLastName(userInfo.getLastName());
        userInfo.setUsername(userInfo.getUsername());
        userInfo.setEmail(userInfo.getEmail());
        userInfo.setPhone(userInfo.getPhone());
        userInfo.setAddressLine1(userInfo.getAddressLine1());
        userInfo.setAddressLine2(userInfo.getAddressLine2());
        userInfo.setCountry(userInfo.getCountry());
        userInfo.setCity(userInfo.getCity());
        userInfo.setState(userInfo.getState());
        userInfo.setZipcode(userInfo.getZipcode());

// Save the UserInfo object to the database
        userInfoRepository.save(userInfo);


    }



}
