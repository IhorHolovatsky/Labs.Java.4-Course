package com.supplyProduct;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
public class SupplyProductController {

    private final SupplyProductService supplyService;

    @Autowired
    public SupplyProductController(SupplyProductService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping("/")
    public String home(){
        return "<a href=\"/api/supply\">API Supply</a>" +
                "<br />" +
                "<a href=\"/api/supply/1\">API Supply Products With ID=1</a>";
    }

    @GetMapping("/api/suppliedProducts")
    public List<SupplyProductModel> getProducts(){
        return supplyService.getList();
    }

    @GetMapping("/api/getSuppliedProduct/{id}")
    public SupplyProductModel getProductById(@PathVariable Integer id){
        return supplyService.get(id);
    }

    @GetMapping("/api/deleteSuppliedProduct/{id}")
    public String deleteProductById(@PathVariable Integer id){
        supplyService.delete(id);
        return "redirect:/api/suppliedProducts";
    }

    @PostMapping(path = "/api/addProduct", consumes = "application/json", produces = "application/json")
    public String addProduct(@RequestBody SupplyProductModel model){
        supplyService.add(model);
        return "redirect:/api/suppliedProducts";
    }

}
