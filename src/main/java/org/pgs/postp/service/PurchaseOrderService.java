package org.pgs.postp.service;

import org.pgs.postp.dto.PurchaseOrderDTO;

import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseOrderDTO> getAllPurchaseOrders();

    PurchaseOrderDTO getPurchaseOrderById(Long id);

    PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO);

    PurchaseOrderDTO updatePurchaseOrder(Long id, PurchaseOrderDTO purchaseOrderDTO);

    void deletePurchaseOrder(Long id);
}