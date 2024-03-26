package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.CustomerPurchaseHistoryDTO;
import org.pgs.postp.mapper.CustomerPurchaseHistoryMapper;
import org.pgs.postp.model.CustomerModel;
import org.pgs.postp.model.CustomerPurchaseHistoryModel;
import org.pgs.postp.model.TransactionModel;
import org.pgs.postp.repository.CustomerPurchaseHistoryRepository;
import org.pgs.postp.repository.CustomerRepository;
import org.pgs.postp.repository.TransactionRepository;
import org.pgs.postp.service.CustomerPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerPurchaseHistoryServiceImpl implements CustomerPurchaseHistoryService {

    private final CustomerPurchaseHistoryRepository purchaseHistoryRepository;

    private final CustomerRepository customerRepository;

    private final TransactionRepository transactionRepository;

    private final CustomerPurchaseHistoryMapper purchaseHistoryMapper;

    @Autowired
    public CustomerPurchaseHistoryServiceImpl(CustomerPurchaseHistoryRepository purchaseHistoryRepository, CustomerPurchaseHistoryMapper purchaseHistoryMapper, CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
        this.purchaseHistoryMapper = purchaseHistoryMapper;
    }

    @Override
    public List<CustomerPurchaseHistoryDTO> getAllPurchaseHistory() {
        List<CustomerPurchaseHistoryModel> purchaseHistory = purchaseHistoryRepository.findAll();
        return purchaseHistory.stream()
                .map(purchaseHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerPurchaseHistoryDTO getPurchaseHistoryById(Long id) {
        CustomerPurchaseHistoryModel purchaseHistory = purchaseHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase history not found with id: " + id));
        return purchaseHistoryMapper.toDTO(purchaseHistory);
    }

//    @Override
//    public CustomerPurchaseHistoryDTO createPurchaseHistory(CustomerPurchaseHistoryDTO purchaseHistoryDTO) {
//        CustomerPurchaseHistoryModel purchaseHistory = purchaseHistoryMapper.toEntity(purchaseHistoryDTO);
//        CustomerPurchaseHistoryModel savedPurchaseHistory = purchaseHistoryRepository.save(purchaseHistory);
//        return purchaseHistoryMapper.toDTO(savedPurchaseHistory);
//    }

    @Override
    public CustomerPurchaseHistoryDTO createPurchaseHistory(CustomerPurchaseHistoryDTO purchaseHistoryDTO) {
        if (purchaseHistoryDTO.getCustomerId() == null) {
            throw new IllegalArgumentException("Customer ID must be provided");
        }
        if (purchaseHistoryDTO.getTransactionId() == null) {
            throw new IllegalArgumentException("Transaction ID must be provided");
        }

        // Fetch the customer from the database
        CustomerModel customer = customerRepository.findById(purchaseHistoryDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + purchaseHistoryDTO.getCustomerId()));
        // Fetch the transaction from the database
        TransactionModel transaction = transactionRepository.findById(purchaseHistoryDTO.getTransactionId())
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + purchaseHistoryDTO.getTransactionId()));

        // Create the CustomerPurchaseHistory entity and set the customer
        // Create the CustomerPurchaseHistory entity and set the transaction
        CustomerPurchaseHistoryModel purchaseHistory = new CustomerPurchaseHistoryModel(
                customer,
                transaction,
                purchaseHistoryDTO.getPurchaseDate()
                );

        //Save the customer to the database
        //Save the transaction to the database
        CustomerPurchaseHistoryModel savedPurchaseHistory = purchaseHistoryRepository.save(purchaseHistory);
        return purchaseHistoryMapper.toDTO(savedPurchaseHistory);

    }

    @Override
    public CustomerPurchaseHistoryDTO updatePurchaseHistory(Long id, CustomerPurchaseHistoryDTO purchaseHistoryDTO) {
        CustomerPurchaseHistoryModel existingPurchaseHistory = purchaseHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase history not found with id: " + id));
        if(purchaseHistoryDTO.getPurchaseDate()!=null){
            existingPurchaseHistory.setPurchaseDate(purchaseHistoryDTO.getPurchaseDate());
        }
        // Update properties here
        CustomerPurchaseHistoryModel updatedPurchaseHistory = purchaseHistoryRepository.save(existingPurchaseHistory);
        return purchaseHistoryMapper.toDTO(updatedPurchaseHistory);
    }

    @Override
    public void deletePurchaseHistory(Long id) {
        if (!purchaseHistoryRepository.existsById(id)) {
            throw new RuntimeException("Purchase history not found with id: " + id);
        }
        purchaseHistoryRepository.deleteById(id);
    }
}
