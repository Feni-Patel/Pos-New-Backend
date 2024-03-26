package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.TransactionDetailDTO;
import org.pgs.postp.mapper.TransactionDetailMapper;
import org.pgs.postp.model.*;
import org.pgs.postp.repository.ProductRepository;
import org.pgs.postp.repository.TransactionDetailRepository;
import org.pgs.postp.repository.TransactionRepository;
import org.pgs.postp.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {

    private final TransactionDetailRepository transactionDetailRepository;

    private final TransactionRepository transactionRepository;

    private final ProductRepository productRepository;
    private final TransactionDetailMapper transactionDetailMapper;

    @Autowired
    public TransactionDetailServiceImpl(TransactionDetailRepository transactionDetailRepository, TransactionDetailMapper transactionDetailMapper, TransactionRepository transactionRepository, ProductRepository productRepository) {
        this.transactionDetailRepository = transactionDetailRepository;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.transactionDetailMapper = transactionDetailMapper;
    }

    @Override
    public List<TransactionDetailDTO> getAllTransactionDetails() {
        List<TransactionDetailModel> transactionDetails = transactionDetailRepository.findAll();
        return transactionDetails.stream()
                .map(transactionDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDetailDTO getTransactionDetailById(Long id) {
        TransactionDetailModel transactionDetail = transactionDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction Detail not found with id: " + id));
        return transactionDetailMapper.toDTO(transactionDetail);
    }

//    @Override
//    public TransactionDetailDTO createTransactionDetail(TransactionDetailDTO transactionDetailDTO) {
//        TransactionDetailModel transactionDetail = transactionDetailMapper.toEntity(transactionDetailDTO);
//        TransactionDetailModel savedTransactionDetail = transactionDetailRepository.save(transactionDetail);
//        return transactionDetailMapper.toDTO(savedTransactionDetail);
//    }

    @Override
    public TransactionDetailDTO createTransactionDetail(TransactionDetailDTO transactionDetailDTO) {
        if (transactionDetailDTO.getTransactionID() == null) {
            throw new IllegalArgumentException("Transaction ID must be provided");
        }
        if (transactionDetailDTO.getProductID() == null) {
            throw new IllegalArgumentException("Product ID must be provided");
        }

        // Fetch the transaction from the database
        TransactionModel transaction = transactionRepository.findById(transactionDetailDTO.getTransactionID())
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + transactionDetailDTO.getTransactionID()));
        // Fetch the product from the database
        ProductModel product = productRepository.findById(transactionDetailDTO.getProductID())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + transactionDetailDTO.getProductID()));

        // Create the TransactionDetailModel entity and set the transaction
        // Create the TransactionDetailModel entity and set the product
        TransactionDetailModel transactionDetail = new TransactionDetailModel(
                transaction,
                product,
                transactionDetailDTO.getQuantity(),
                transactionDetailDTO.getUnitPrice(),
                transactionDetailDTO.getDiscount() );

        // Save the transaction to the database
        // Save the product to the database
        TransactionDetailModel savedTransactionDetail = transactionDetailRepository.save(transactionDetail);
        return transactionDetailMapper.toDTO(savedTransactionDetail);

    }



    @Override
    public TransactionDetailDTO updateTransactionDetail(Long id, TransactionDetailDTO transactionDetailDTO) {
        // Check if the transaction detail with the given ID exists
        TransactionDetailModel existingTransactionDetail = transactionDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction Detail not found with id: " + id));

        // Update the properties of the existing TransactionDetailModel with the data from transactionDetailDTO
        existingTransactionDetail.setQuantity(transactionDetailDTO.getQuantity());
        existingTransactionDetail.setUnitPrice(transactionDetailDTO.getUnitPrice());
        existingTransactionDetail.setDiscount(transactionDetailDTO.getDiscount());
        // Update other properties as needed

        // Save the updated TransactionDetailModel
        TransactionDetailModel updatedTransactionDetail = transactionDetailRepository.save(existingTransactionDetail);

        // Map the updated TransactionDetailModel to a TransactionDetailDTO and return it
        return transactionDetailMapper.toDTO(updatedTransactionDetail);
    }

    @Override
    public void deleteTransactionDetail(Long id) {
        if (!transactionDetailRepository.existsById(id)) {
            throw new RuntimeException("Transaction Detail not found with id: " + id);
        }
        transactionDetailRepository.deleteById(id);
    }
}
