package org.pgs.postp.mapper;

import org.pgs.postp.dto.InventoryDTO;
import org.pgs.postp.model.InventoryModel;
import org.pgs.postp.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {

    public InventoryDTO toDTO(InventoryModel inventoryModel) {
        if (inventoryModel == null) {
            return null;
        }
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setInventoryID(inventoryModel.getInventoryID());
        inventoryDTO.setProductId(inventoryModel.getProduct().getProductId());
        inventoryDTO.setQuantity(inventoryModel.getQuantity());
        return inventoryDTO;
    }

    public InventoryModel toEntity(InventoryDTO inventoryDTO) {
        if (inventoryDTO == null) {
            return null;
        }
        InventoryModel inventoryModel = new InventoryModel();
        inventoryModel.setInventoryID(inventoryDTO.getInventoryID());
        inventoryModel.setQuantity(inventoryDTO.getQuantity());
        // Assuming productId is set via ProductModel object in InventoryModel
        if (inventoryDTO.getProductId() != null) {
            ProductModel product = new ProductModel();
            product.setProductId(inventoryDTO.getProductId());
            inventoryModel.setProduct(product);
        }
        return inventoryModel;
    }
}
