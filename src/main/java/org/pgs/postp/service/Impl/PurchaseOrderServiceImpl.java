package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.PurchaseOrderDTO;
import org.pgs.postp.mapper.PurchaseOrderMapper;
import org.pgs.postp.model.PurchaseOrderModel;
import org.pgs.postp.repository.PurchaseOrderRepository;
import org.pgs.postp.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository, PurchaseOrderMapper purchaseOrderMapper) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderMapper = purchaseOrderMapper;
    }

    @Override
    public List<PurchaseOrderDTO> getAllPurchaseOrders() {
        List<PurchaseOrderModel> purchaseOrders = purchaseOrderRepository.findAll();
        return purchaseOrders.stream()
                .map(purchaseOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseOrderDTO getPurchaseOrderById(Long id) {
        PurchaseOrderModel purchaseOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase order not found with id: " + id));
        return purchaseOrderMapper.toDTO(purchaseOrder);
    }

    @Override
    public PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrderModel purchaseOrder = purchaseOrderMapper.toEntity(purchaseOrderDTO);
        // Additional logic if needed
        PurchaseOrderModel savedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        return purchaseOrderMapper.toDTO(savedPurchaseOrder);
    }

    @Override
    public PurchaseOrderDTO updatePurchaseOrder(Long id, PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrderModel existingPurchaseOrder = purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase order not found with id: " + id));

        // Update fields here

        if (purchaseOrderDTO.getSupplier() != null) {
            existingPurchaseOrder.setSupplier(purchaseOrderDTO.getSupplier());
        }
        if (purchaseOrderDTO.getProducts() != null) {
            existingPurchaseOrder.setProducts(purchaseOrderDTO.getProducts());
        }
        if (purchaseOrderDTO.getStore() != null) {
            existingPurchaseOrder.setStore(purchaseOrderDTO.getStore());
        }
        if (purchaseOrderDTO.getQuantity() != null) {
            existingPurchaseOrder.setQuantity(purchaseOrderDTO.getQuantity());
        }
        if (purchaseOrderDTO.getBuyingPrice() != null) {
            existingPurchaseOrder.setBuyingPrice(purchaseOrderDTO.getBuyingPrice());
        }
        if (purchaseOrderDTO.getSellingPrice() != null) {
            existingPurchaseOrder.setSellingPrice(purchaseOrderDTO.getSellingPrice());
        }
        if (purchaseOrderDTO.getOrderDate() != null) {
            existingPurchaseOrder.setOrderDate(purchaseOrderDTO.getOrderDate());
        }
        if (purchaseOrderDTO.getDeliverDate() != null) {
            existingPurchaseOrder.setDeliverDate(purchaseOrderDTO.getDeliverDate());
        }
        if (purchaseOrderDTO.getTransportMethod() != null) {
            existingPurchaseOrder.setTransportMethod(purchaseOrderDTO.getTransportMethod());
        }
        if (purchaseOrderDTO.getPaymentMethod() != null) {
            existingPurchaseOrder.setPaymentMethod(purchaseOrderDTO.getPaymentMethod());
        }

        if (purchaseOrderDTO.getStatus() != null) {
            existingPurchaseOrder.setStatus(purchaseOrderDTO.getStatus());
        }

        // Save the updated purchase order
        PurchaseOrderModel updatedPurchaseOrder = purchaseOrderRepository.save(existingPurchaseOrder);
        return purchaseOrderMapper.toDTO(updatedPurchaseOrder);
    }

    @Override
    public void deletePurchaseOrder(Long id) {
        if (!purchaseOrderRepository.existsById(id)) {
            throw new RuntimeException("Purchase order not found with id: " + id);
        }
        purchaseOrderRepository.deleteById(id);
    }
}