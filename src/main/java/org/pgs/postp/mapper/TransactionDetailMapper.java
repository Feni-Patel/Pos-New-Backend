package org.pgs.postp.mapper;

import org.pgs.postp.dto.TransactionDetailDTO;
import org.pgs.postp.model.TransactionDetailModel;
import org.springframework.stereotype.Component;

@Component
public class TransactionDetailMapper {

    // Convert TransactionDetailModel to TransactionDetailDTO
    public TransactionDetailDTO toDTO(TransactionDetailModel model) {
        TransactionDetailDTO dto = new TransactionDetailDTO();
        dto.setTransactionDetailID(model.getTransactionDetailID());
        dto.setTransactionID(model.getTransaction().getTransactionID()); // Assuming TransactionModel has a getTransactionID() method
        dto.setProductID(model.getProduct().getProductId()); // Assuming ProductModel has a getProductId() method
        dto.setQuantity(model.getQuantity());
        dto.setUnitPrice(model.getUnitPrice());
        dto.setDiscount(model.getDiscount());
        // You might choose to map other properties here, depending on your requirements
        return dto;
    }

    // Convert TransactionDetailDTO to TransactionDetailModel
    public static TransactionDetailModel toEntity(TransactionDetailDTO dto) {
        TransactionDetailModel model = new TransactionDetailModel();
        model.setTransactionDetailID(dto.getTransactionDetailID());
        // You might need to fetch TransactionModel and ProductModel from the database based on the IDs in the DTO
        // and then set them to the model object
        model.setQuantity(dto.getQuantity());
        model.setUnitPrice(dto.getUnitPrice());
        model.setDiscount(dto.getDiscount());
        // You might choose to map other properties here, depending on your requirements
        return model;
    }
}
