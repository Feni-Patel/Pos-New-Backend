package org.pgs.postp.repository;

import org.pgs.postp.model.PurchaseOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderModel, Long> {
    // You can add custom query methods if needed
}