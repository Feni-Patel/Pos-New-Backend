package org.pgs.postp.repository;

import org.pgs.postp.model.BarcodeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcodeRepository extends JpaRepository<BarcodeModel, Long> {
    // You can add custom query methods if needed
}
