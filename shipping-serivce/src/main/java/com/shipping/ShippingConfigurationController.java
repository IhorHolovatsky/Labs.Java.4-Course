package com.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShippingConfigurationController {

    @Value("${some.name1}")
    private String prop1;
    @Value("${some.name2}")
    private String prop2;
    @Value("${some.name3}")
    private String prop3;


    @RequestMapping(value = "/api/config", method = RequestMethod.GET)
    public List<String> getConfigurations(){
        List<String> list =  new ArrayList<String>();
        list.add(prop1);
        list.add(prop2);
        list.add(prop3);
        return list;
    }
}
