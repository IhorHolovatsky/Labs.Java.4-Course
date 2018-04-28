package com.shipping.services;

import com.shipping.models.ShipmentModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShippingService {
    private static Map<UUID, ShipmentModel> _shipments = new HashMap<UUID, ShipmentModel>();

    static {
        ShipmentModel model1 = new ShipmentModel(UUID.randomUUID(), UUID.randomUUID(), "Ukraine", "Kyiv", UUID.randomUUID(), UUID.randomUUID(), "Shipped");
        ShipmentModel model2 =new ShipmentModel(UUID.randomUUID(), UUID.randomUUID(), "Ukraine", "Kyiv", UUID.randomUUID(), UUID.randomUUID(), "Shipped");
        ShipmentModel model3 = new ShipmentModel(UUID.randomUUID(), UUID.randomUUID(), "Germany", "Berlin", UUID.randomUUID(), UUID.randomUUID(), "Shipped");
        ShipmentModel model4 = new ShipmentModel(UUID.randomUUID(), UUID.randomUUID(), "France", "Paris", UUID.randomUUID(), UUID.randomUUID(), "Shipped");
         _shipments.put(model1.getId(), model1);
         _shipments.put(model2.getId(), model2);
         _shipments.put(model3.getId(), model3);
         _shipments.put(model4.getId(), model4);
    }


    public List<ShipmentModel> list() {
        return new ArrayList<ShipmentModel>(_shipments.values());
    }

    public ShipmentModel create(UUID orderId,
                                String country,
                                String city,
                                UUID storeId,
                                UUID customerId){
        ShipmentModel model = new ShipmentModel(UUID.randomUUID(),
                                                orderId,
                                                country,
                                                city,
                                                storeId,
                                                customerId,
                                                "Shipped");

        _shipments.put(model.getId(), model);

        return model;
    }

    public ShipmentModel getById(UUID shipmentId){
        return _shipments.containsKey(shipmentId)
                ? _shipments.get(shipmentId)
                : null;
    }
}
