package org.pgs.postp.repository;

import org.pgs.postp.model.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {
    // You can add custom query methods if needed
}
