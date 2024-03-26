package org.pgs.postp.repository;

import org.pgs.postp.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    // You can add custom query methods here if needed
//
    Optional<ProductModel> findByBarcodeNumber(String barcodeNumber);

}