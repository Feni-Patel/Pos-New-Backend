package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.TransactionDTO;
import org.pgs.postp.mapper.TransactionMapper;
import org.pgs.postp.model.*;
import org.pgs.postp.repository.CustomerRepository;
import org.pgs.postp.repository.TransactionRepository;
import org.pgs.postp.repository.UserRepository;
import org.pgs.postp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;


    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper, UserRepository userRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<TransactionModel> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        TransactionModel transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
        return transactionMapper.toDTO(transaction);
    }

//    @Override
//    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
//        TransactionModel transaction = transactionMapper.toEntity(transactionDTO);
//        TransactionModel savedTransaction = transactionRepository.save(transaction);
//        return transactionMapper.toDTO(savedTransaction);
//    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        if (transactionDTO.getUserID() == null) {
            throw new IllegalArgumentException("User ID must be provided");
        }
        if (transactionDTO.getCustomerID() == null) {
            throw new IllegalArgumentException("Customer ID must be provided");
        }

        // Fetch the user from the database
        UserModel user = userRepository.findById(transactionDTO.getUserID())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + transactionDTO.getUserID()));
        // Fetch the customer from the database
        CustomerModel customer = customerRepository.findById(transactionDTO.getCustomerID())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + transactionDTO.getCustomerID()));

        // Create the TransactionModel entity and set the user
        // Create the TransactionModel entity and set the customer
        TransactionModel transaction = new TransactionModel(
                user,
                customer,
                transactionDTO.getTotalAmount(),
                transactionDTO.getPaymentMethod(),
                transactionDTO.getTransactionDate() );

        // Save the user to the database
        // Save the customer to the database
        TransactionModel savedTransaction = transactionRepository.save(transaction);
        return transactionMapper.toDTO(savedTransaction);

    }


    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
        TransactionModel existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));

        if(transactionDTO.getTotalAmount()!=null){
            existingTransaction.setTotalAmount(transactionDTO.getTotalAmount());
        }
        if(transactionDTO.getPaymentMethod()!=null){
            existingTransaction.setPaymentMethod(transactionDTO.getPaymentMethod());
        }
        if(transactionDTO.getTransactionDate()!=null){
            existingTransaction.setTransactionDate(transactionDTO.getTransactionDate());
        }
        // Update properties here
        TransactionModel updatedTransaction = transactionRepository.save(existingTransaction);
        return transactionMapper.toDTO(updatedTransaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new RuntimeException("Transaction not found with id: " + id);
        }
        transactionRepository.deleteById(id);
    }
}
