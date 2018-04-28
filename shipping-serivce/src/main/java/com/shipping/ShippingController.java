package com.shipping;

import com.shipping.models.ShipmentModel;
import com.shipping.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService _shippingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("redirect:swagger-ui.html");
    }

    @RequestMapping(value = "/api/shipments", method = RequestMethod.GET)
    public List<ShipmentModel> getShipments(){
        return _shippingService.list();
    }

    @RequestMapping(value = "/api/shipments/{id}", method = RequestMethod.GET)
    public ShipmentModel getShipment(@PathVariable UUID id){
        return _shippingService.getById(id);
    }


    @RequestMapping(value = "/api/shipments", method = RequestMethod.POST)
    public ShipmentModel createShipment(String orderId, String country, String city, String storeId, String customerId){
        return _shippingService.create(UUID.fromString(orderId), country, city, UUID.fromString(storeId), UUID.fromString(customerId));
    }

}
