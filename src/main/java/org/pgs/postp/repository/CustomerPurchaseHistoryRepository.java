package org.pgs.postp.repository;

import org.pgs.postp.model.CustomerPurchaseHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPurchaseHistoryRepository extends JpaRepository<CustomerPurchaseHistoryModel, Long> {
    // You can add custom query methods if needed
}
