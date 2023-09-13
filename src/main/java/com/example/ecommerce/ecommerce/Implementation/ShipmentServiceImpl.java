package com.example.ecommerce.ecommerce.Implementation;

import com.example.ecommerce.ecommerce.Entity.OrderItem;
import com.example.ecommerce.ecommerce.Entity.Shipment;
import com.example.ecommerce.ecommerce.Repository.ShipmentRepository;
import com.example.ecommerce.ecommerce.Service.CartService;
import com.example.ecommerce.ecommerce.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepository shipmentRepository;
    private final CartService cartService; // Declare cartService as final

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, CartService cartService) {
        this.shipmentRepository = shipmentRepository;
        this.cartService = cartService; // Initialize cartService in the constructor
    }
    @Override
    public Shipment createShipment(Shipment shipment) {
        List<String> productNames = new ArrayList<>();
        List<OrderItem> cartItems = cartService.getCartItems();
        for (OrderItem item : cartItems) {
            productNames.add(item.getProduct().getTitle());
        }

        shipment.setProductNames(productNames);
        return shipmentRepository.save(shipment);
    }
    @Override
    public Shipment updateShipmentStatus(String id, String NewStatus) {
        Optional<Shipment> optionalShipment = shipmentRepository.findById(id);

        if (optionalShipment.isPresent()) {
            Shipment shipment = optionalShipment.get();
            shipment.setStatus(NewStatus);
            return shipmentRepository.save(shipment);
        }

        return null; // Handle not found case
    }
//    @Override
//    public Shipment updateShipment(String id, Shipment shipment) {
//        if (shipmentRepository.existsById(id)) {
//            shipment.setId(id);
//            return shipmentRepository.save(shipment);
//        }
//        return null;
//    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipmentById(String id) {
        return shipmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteShipment(String id) {
        shipmentRepository.deleteById(id);
    }
}
