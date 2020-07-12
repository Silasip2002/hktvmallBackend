package com.hktv.productAPI.repository;

import com.hktv.productAPI.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    List<Warehouse> findByProductCode(String productCode);
}
