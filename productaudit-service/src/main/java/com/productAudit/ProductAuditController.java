package com.productAudit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductAuditController {

    private final ProductAuditService auditService;

    @Autowired
    public ProductAuditController(ProductAuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/")
    public String home() {
        return "<a href=\"/api/productsAudit\">API Audit Products</a>" +
                "<br />" +
                "<a href=\"/api/productsAudit/1\">API Audit Products With ID=1</a>" +
                "<br />" +
                "<a href=\"/api/config\">API Config</a>";
    }

    @GetMapping("/api/productsAudit")
    public List<ProductAuditModel> getProductsAudit() {
        return auditService.list();
    }

    @GetMapping("/api/productsAudit/{auditId}")
    public ProductAuditModel getProductAudit(@PathVariable Integer auditId) {
        return auditService.get(auditId);
    }

    @PostMapping(path = "/api/productsAudit", consumes = "application/json", produces = "application/json")
    public String create(@RequestBody ProductAuditModel audit) {
        auditService.create(audit);
        return "redirect:/api/productsAudit/" + audit.Product.Id;
    }

    @PostMapping(path = "/api/productsAudit/delete/{auditId}", consumes = "application/json", produces = "application/json")
    public String delete(@PathVariable Integer auditId) {
        auditService.delete(auditId);
        return "redirect:/api/productsAudit/";
    }
}