package org.pgs.postp.repository;

import org.pgs.postp.model.InvoiceReturnModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceReturnRepository extends JpaRepository<InvoiceReturnModel, Long> {
    // You can add custom query methods if needed
}
