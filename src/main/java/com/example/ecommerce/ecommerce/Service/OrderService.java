package com.example.ecommerce.ecommerce.Service;

import com.example.ecommerce.ecommerce.Entity.Order;
import com.example.ecommerce.ecommerce.Entity.OrderItem;
import com.example.ecommerce.ecommerce.Entity.Products;
import com.example.ecommerce.ecommerce.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface OrderService {
    void addItemToCart(Products product);
    void removeItemFromCart(Products product);
    List<OrderItem> getCartItems();
    double getTotalCost();

    // You can add more methods like getOrderHistoryForUser, cancelOrder, etc.
}
