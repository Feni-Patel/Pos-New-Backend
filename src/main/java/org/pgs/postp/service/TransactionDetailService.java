package org.pgs.postp.service;

import org.pgs.postp.dto.TransactionDetailDTO;

import java.util.List;

public interface TransactionDetailService {
    List<TransactionDetailDTO> getAllTransactionDetails();

    TransactionDetailDTO getTransactionDetailById(Long id);

    TransactionDetailDTO createTransactionDetail(TransactionDetailDTO transactionDetailDTO);

    TransactionDetailDTO updateTransactionDetail(Long id, TransactionDetailDTO transactionDetailDTO);

    void deleteTransactionDetail(Long id);
}
