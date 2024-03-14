package org.pgs.postp.repository;

import org.pgs.postp.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    // You can add custom query methods if needed
}
