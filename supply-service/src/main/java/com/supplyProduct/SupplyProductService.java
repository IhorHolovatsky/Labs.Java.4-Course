package com.supplyProduct;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplyProductService {
    private static Map<Integer, SupplyProductModel> products = new HashMap<Integer, SupplyProductModel>();

    static {
        SupplyProductModel firstAudit = new SupplyProductModel(1, 10,"Test1","Test 1");
        products.put(1, firstAudit);

        SupplyProductModel secondAudit = new SupplyProductModel(2, 10,"Test2","Test 2");
        products.put(2, secondAudit);

        SupplyProductModel thirdAudit = new SupplyProductModel(3, 10,"Test3","Test 3");
        products.put(3, thirdAudit);

        SupplyProductModel firthAudit = new SupplyProductModel(4, 10,"Test4","Test 4");
        products.put(4, firthAudit);
    }

    public List<SupplyProductModel> getList() {
        return new ArrayList<SupplyProductModel>(products.values());
    }

    public SupplyProductModel get(Integer Id) {
        return products.get(Id);
    }

    public static SupplyProductModel add(SupplyProductModel model) {

        return products.put(model.Id, model);
    }

    public static SupplyProductModel delete(Integer Id) {
        return products.remove(Id);
    }
}
