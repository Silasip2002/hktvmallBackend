package com.hktv.productAPI.repository;
import com.hktv.productAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    @Query(value = "SELECT product.code, product.name, product.weight, location.location,location.quantity " +
            "FROM product INNER JOIN location ON product.code=location.productCode;", nativeQuery = true)
    List<Product> listAllProducts();

}
