package org.pgs.postp.service;

import org.pgs.postp.dto.CustomerPurchaseHistoryDTO;

import java.util.List;

public interface CustomerPurchaseHistoryService {
    List<CustomerPurchaseHistoryDTO> getAllPurchaseHistory();

    CustomerPurchaseHistoryDTO getPurchaseHistoryById(Long id);

    CustomerPurchaseHistoryDTO createPurchaseHistory(CustomerPurchaseHistoryDTO purchaseHistoryDTO);

    CustomerPurchaseHistoryDTO updatePurchaseHistory(Long id, CustomerPurchaseHistoryDTO purchaseHistoryDTO);

    void deletePurchaseHistory(Long id);
}
