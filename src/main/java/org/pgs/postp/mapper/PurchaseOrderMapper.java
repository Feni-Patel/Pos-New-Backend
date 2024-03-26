package org.pgs.postp.mapper;

import org.pgs.postp.dto.PurchaseOrderDTO;
import org.pgs.postp.model.PurchaseOrderModel;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderMapper {

    public PurchaseOrderDTO toDTO(PurchaseOrderModel purchaseOrderModel) {
        if (purchaseOrderModel == null) {
            return null;
        }
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        // Map fields from PurchaseOrderModel to PurchaseOrderDTO
        purchaseOrderDTO.setId(purchaseOrderModel.getId());
        purchaseOrderDTO.setSupplier(purchaseOrderModel.getSupplier());
        purchaseOrderDTO.setProducts(purchaseOrderModel.getProducts());
        purchaseOrderDTO.setStore(purchaseOrderModel.getStore());
        purchaseOrderDTO.setQuantity(purchaseOrderModel.getQuantity());
        purchaseOrderDTO.setBuyingPrice(purchaseOrderModel.getBuyingPrice());
        purchaseOrderDTO.setSellingPrice(purchaseOrderModel.getSellingPrice());
        purchaseOrderDTO.setOrderDate(purchaseOrderModel.getOrderDate());
        purchaseOrderDTO.setDeliverDate(purchaseOrderModel.getDeliverDate());
        purchaseOrderDTO.setTransportMethod(purchaseOrderModel.getTransportMethod());
        purchaseOrderDTO.setPaymentMethod(purchaseOrderModel.getPaymentMethod());
        purchaseOrderDTO.setStatus(purchaseOrderModel.getStatus());
        return purchaseOrderDTO;
    }

    public PurchaseOrderModel toEntity(PurchaseOrderDTO purchaseOrderDTO) {
        if (purchaseOrderDTO == null) {
            return null;
        }
        PurchaseOrderModel purchaseOrderModel = new PurchaseOrderModel();
        // Map fields from PurchaseOrderDTO to PurchaseOrderModel
        purchaseOrderModel.setId(purchaseOrderDTO.getId());
        purchaseOrderModel.setSupplier(purchaseOrderDTO.getSupplier());
        purchaseOrderModel.setProducts(purchaseOrderDTO.getProducts());
        purchaseOrderModel.setStore(purchaseOrderDTO.getStore());
        purchaseOrderModel.setQuantity(purchaseOrderDTO.getQuantity());
        purchaseOrderModel.setBuyingPrice(purchaseOrderDTO.getBuyingPrice());
        purchaseOrderModel.setSellingPrice(purchaseOrderDTO.getSellingPrice());
        purchaseOrderModel.setOrderDate(purchaseOrderDTO.getOrderDate());
        purchaseOrderModel.setDeliverDate(purchaseOrderDTO.getDeliverDate());
        purchaseOrderModel.setTransportMethod(purchaseOrderDTO.getTransportMethod());
        purchaseOrderModel.setPaymentMethod(purchaseOrderDTO.getPaymentMethod());
        purchaseOrderModel.setStatus(purchaseOrderDTO.getStatus());
        return purchaseOrderModel;
    }
}