package com.shipping;

import com.shipping.models.ShipmentModel;
import com.shipping.services.ShippingService;
import com.supplyProduct.SupplyProductClient;
import com.supplyProduct.SupplyProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class ShippingController {

    @Autowired
    private ShippingService _shippingService;

    @Autowired
    private DiscoveryClient discoveryClient;


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

    @RequestMapping(value = "/api/callSupplyService/{id}", method = RequestMethod.GET)
    public SupplyProductModel callAnotherService(@PathVariable Integer id){
        return getSupplyProduct(id).getBody();
    }

    public URI getSupplyProductUri(int id){
        ServiceInstance instance = discoveryClient.getInstances("supply-service").get(0);

        String url = instance.getUri().toString();

        return UriComponentsBuilder.fromHttpUrl(url + "/api/getSuppliedProduct/" + id)
                .build()
                .toUri();
    }

    public ResponseEntity<SupplyProductModel> getSupplyProduct(int id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(getSupplyProductUri(id), SupplyProductModel.class);
    }

}
