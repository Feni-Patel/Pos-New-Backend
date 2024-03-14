package org.pgs.postp.repository;

import org.pgs.postp.model.TaxModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<TaxModel, Long> {
    // You can add custom query methods if needed
}
