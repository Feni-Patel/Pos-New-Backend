package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.CustomerPurchaseHistoryDTO;
import org.pgs.postp.mapper.CustomerPurchaseHistoryMapper;
import org.pgs.postp.model.CustomerPurchaseHistoryModel;
import org.pgs.postp.repository.CustomerPurchaseHistoryRepository;
import org.pgs.postp.service.CustomerPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerPurchaseHistoryServiceImpl implements CustomerPurchaseHistoryService {

    private final CustomerPurchaseHistoryRepository purchaseHistoryRepository;
    private final CustomerPurchaseHistoryMapper purchaseHistoryMapper;

    @Autowired
    public CustomerPurchaseHistoryServiceImpl(CustomerPurchaseHistoryRepository purchaseHistoryRepository, CustomerPurchaseHistoryMapper purchaseHistoryMapper) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
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

    @Override
    public CustomerPurchaseHistoryDTO createPurchaseHistory(CustomerPurchaseHistoryDTO purchaseHistoryDTO) {
        CustomerPurchaseHistoryModel purchaseHistory = purchaseHistoryMapper.toEntity(purchaseHistoryDTO);
        CustomerPurchaseHistoryModel savedPurchaseHistory = purchaseHistoryRepository.save(purchaseHistory);
        return purchaseHistoryMapper.toDTO(savedPurchaseHistory);
    }

    @Override
    public CustomerPurchaseHistoryDTO updatePurchaseHistory(Long id, CustomerPurchaseHistoryDTO purchaseHistoryDTO) {
        CustomerPurchaseHistoryModel existingPurchaseHistory = purchaseHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase history not found with id: " + id));
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
