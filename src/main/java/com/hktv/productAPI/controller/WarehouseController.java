package com.hktv.productAPI.controller;

import com.hktv.productAPI.model.Warehouse;
import com.hktv.productAPI.repository.ProductRepository;
import com.hktv.productAPI.repository.WarehouseRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseController {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/{code}/warehouses")
    public List<Warehouse> getWarehouseByProductCode(@PathVariable String productCode) {

        if(!productRepository.existsById(productCode)) {
            System.out.print("product not found.");
        }
        return warehouseRepository.findByProductCode(productCode);
    }
}
