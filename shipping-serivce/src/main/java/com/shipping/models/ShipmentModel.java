package com.shipping.models;

import java.util.Date;
import java.util.UUID;

public class ShipmentModel {

    private UUID Id;
    public UUID OrderId;
    public String Country;
    public String City;
    public UUID StoreId;
    public UUID CustomerId;
    public Date DateShipped;
    public String Status;

    public ShipmentModel() {}

    public ShipmentModel(UUID id,
                         UUID orderId,
                         String country,
                         String city,
                         UUID storeid,
                         UUID customerId,
                         String status) {
        Id = id;
        OrderId = orderId;
        Country = country;
        City = city;
        StoreId = storeid;
        CustomerId = customerId;
        Status = status;

        DateShipped = new Date();
    }

    public UUID getId(){
        return Id;
    }
}
