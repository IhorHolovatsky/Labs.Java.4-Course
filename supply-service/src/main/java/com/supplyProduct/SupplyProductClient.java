package com.supplyProduct;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class SupplyProductClient {
    private final DiscoveryClient discoveryClient;

    @Autowired
    public SupplyProductClient(DiscoveryClient discoveryClient){
        this.discoveryClient = discoveryClient;
    }

    public URI getSupplyProductUri(int id){
        ServiceInstance instance = discoveryClient.getInstances("supply-service").get(0);

        String url = instance.getHost();

        return UriComponentsBuilder.fromHttpUrl(url + "/api/getSuppliedProduct/" + id)
                .build()
                .toUri();
    }

    public ResponseEntity<SupplyProductModel> getSupplyProduct(int id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(getSupplyProductUri(id), SupplyProductModel.class);
    }
}
