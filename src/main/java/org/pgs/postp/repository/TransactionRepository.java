package org.pgs.postp.repository;

import org.pgs.postp.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
    // You can add custom query methods if needed
}
