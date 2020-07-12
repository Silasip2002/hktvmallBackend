package com.hktv.productAPI.controller;

import com.hktv.productAPI.model.Warehouse;
import com.hktv.productAPI.repository.ProductRepository;
import com.hktv.productAPI.repository.WarehouseRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/products/{code}/warehouses")
//    public Warehouse addWarehouse(@PathVariable String productCode,
//                                    @Valid @RequestBody Warehouse warehouse) {
//        return warehouseRepository.findByProductCode(productCode)
//                .map(product -> {
//                    warehouse.setProduct(product);
//                    return warehouseRepository.save(product);
//                }).orElseThrow(() -> new NotFoundException("Product not found!"));
//    }

//    @PutMapping("/products/{code}/warehouses/{location}")
//    public Warehouse updateWarehouse(@PathVariable String location,
//                                       @PathVariable int quantity,
//                                       @Valid @RequestBody Warehouse warehouseUpdated) throws NotFoundException {
//
//        if(!warehouseRepository.existsById(location)) {
//            throw new NotFoundException("Student not found!");
//        }
//
//        return warehouseUpdated.findById(location)
//                .map(warehouse -> {
//                    warehouse.setQuantity(warehouseUpdated.getQuantity());
//                    return warehouseRepository.save(warehouse);
//                }).orElseThrow(() -> new NotFoundException("Warehouse not found!"));
//    }

//    @DeleteMapping("/students/{studentId}/assignments/{assignmentId}")
//    public String deleteAssignment(@PathVariable Long studentId,
//                                   @PathVariable Long assignmentId) {
//
//        if(!warehouseRepository.existsById(studentId)) {
//            throw new NotFoundException("Student not found!");
//        }
//
//        return assignmentRepository.findById(assignmentId)
//                .map(assignment -> {
//                    assignmentRepository.delete(assignment);
//                    return "Deleted Successfully!";
//                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
//    }
}
