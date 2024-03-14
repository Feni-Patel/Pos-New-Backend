package org.pgs.postp.repository;

import org.pgs.postp.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryModel, Long> {
    // You can add custom query methods if needed
}
