package org.pgs.postp.mapper;

import org.pgs.postp.dto.CustomerPurchaseHistoryDTO;
import org.pgs.postp.model.CustomerModel;
import org.pgs.postp.model.CustomerPurchaseHistoryModel;
import org.pgs.postp.model.TransactionModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerPurchaseHistoryMapper {

    public CustomerPurchaseHistoryDTO toDTO(CustomerPurchaseHistoryModel historyModel) {
        if (historyModel == null) {
            return null;
        }
        CustomerPurchaseHistoryDTO historyDTO = new CustomerPurchaseHistoryDTO();
        historyDTO.setPurchaseID(historyModel.getPurchaseID());
        historyDTO.setCustomerId(historyModel.getCustomer().getId());
        historyDTO.setTransactionId(historyModel.getTransaction().getTransactionID());
        historyDTO.setPurchaseDate(historyModel.getPurchaseDate());
        return historyDTO;
    }

    public CustomerPurchaseHistoryModel toEntity(CustomerPurchaseHistoryDTO historyDTO) {
        if (historyDTO == null) {
            return null;
        }
        CustomerPurchaseHistoryModel historyModel = new CustomerPurchaseHistoryModel();
        historyModel.setPurchaseID(historyDTO.getPurchaseID());
        // Assuming customer and transaction IDs are set via CustomerModel and TransactionModel objects respectively
        if (historyDTO.getCustomerId() != null) {
            CustomerModel customer = new CustomerModel();
            customer.setId(historyDTO.getCustomerId());
            historyModel.setCustomer(customer);
        }
        if (historyDTO.getTransactionId() != null) {
            TransactionModel transaction = new TransactionModel();
            transaction.setTransactionID(historyDTO.getTransactionId());
            historyModel.setTransaction(transaction);
        }
        historyModel.setPurchaseDate(historyDTO.getPurchaseDate());
        return historyModel;
    }
}
