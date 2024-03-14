package org.pgs.postp.mapper;

import org.pgs.postp.dto.TransactionDTO;
import org.pgs.postp.model.TransactionModel;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    // Convert TransactionModel to TransactionDTO
    public TransactionDTO toDTO(TransactionModel model) {
        TransactionDTO dto = new TransactionDTO();
        dto.setTransactionID(model.getTransactionID());
        dto.setUserID(model.getUser().getUserID()); // Assuming UserModel has a getUserID() method
        dto.setCustomerID(model.getId() != null ? model.getId().getId() : null); // Assuming CustomerModel has a getCustomerID() method
        dto.setTotalAmount(model.getTotalAmount());
        dto.setPaymentMethod(model.getPaymentMethod());
        dto.setTransactionDate(model.getTransactionDate());
        // You might choose to map the list of transaction details here, depending on your requirements
        return dto;
    }

    // Convert TransactionDTO to TransactionModel
    public static TransactionModel toEntity(TransactionDTO dto) {
        TransactionModel model = new TransactionModel();
        model.setTransactionID(dto.getTransactionID());
        // You might need to fetch UserModel and CustomerModel from the database based on the IDs in the DTO
        // and then set them to the model object
        model.setTotalAmount(dto.getTotalAmount());
        model.setPaymentMethod(dto.getPaymentMethod());
        model.setTransactionDate(dto.getTransactionDate());
        // You might choose to map the list of transaction details here, depending on your requirements
        return model;
    }
}
