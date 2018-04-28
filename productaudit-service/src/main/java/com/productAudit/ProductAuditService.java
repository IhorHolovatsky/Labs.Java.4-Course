package com.productAudit;

import Enums.AuditStatus;
import Enums.Sizes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductAuditService {
    private static Map<Integer, ProductAuditModel> audits = new HashMap<Integer, ProductAuditModel>();

    static {
        ProductAuditModel firstAudit = new ProductAuditModel(1, new ProductModel(), "Petro", Sizes.SMALL, AuditStatus.PENDING, false);
        audits.put(1, firstAudit);

        ProductAuditModel secondAudit = new ProductAuditModel(2, new ProductModel(), "Andriy", Sizes.LARGE, AuditStatus.INACTIVE, false);
        audits.put(2, secondAudit);

        ProductAuditModel thirdAudit = new ProductAuditModel(3, new ProductModel(), "Taras", Sizes.MEDIUM, AuditStatus.INACTIVE, true);
        audits.put(3, thirdAudit);

        ProductAuditModel firthAudit = new ProductAuditModel(4, new ProductModel(), "Ihor", Sizes.LARGE, AuditStatus.DELETED, false);
        audits.put(4, firthAudit);
    }

    public List<ProductAuditModel> list() {
        return new ArrayList<ProductAuditModel>(audits.values());
    }

    public ProductAuditModel get(Integer Id) {
        return audits.get(Id);
    }

    public static ProductAuditModel create(ProductModel productModel, ProductAuditModel auditModel) {
        auditModel.SetProductAudit(productModel);

        return audits.put(auditModel.Product.Id, auditModel);
    }

    public static ProductAuditModel delete(Integer Id) {
        return audits.remove(Id);
    }
}

