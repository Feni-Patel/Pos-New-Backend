package org.pgs.postp.repository;

import org.pgs.postp.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {
    // You can add custom query methods if needed
}
