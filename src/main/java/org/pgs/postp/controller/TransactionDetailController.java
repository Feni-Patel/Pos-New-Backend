package org.pgs.postp.controller;

import org.pgs.postp.dto.TransactionDetailDTO;
import org.pgs.postp.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-details")
public class TransactionDetailController {

    private final TransactionDetailService transactionDetailService;

    @Autowired
    public TransactionDetailController(TransactionDetailService transactionDetailService) {
        this.transactionDetailService = transactionDetailService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDetailDTO>> getAllTransactionDetails() {
        List<TransactionDetailDTO> transactionDetails = transactionDetailService.getAllTransactionDetails();
        return new ResponseEntity<>(transactionDetails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDetailDTO> getTransactionDetailById(@PathVariable("id") Long id) {
        TransactionDetailDTO transactionDetailDTO = transactionDetailService.getTransactionDetailById(id);
        return new ResponseEntity<>(transactionDetailDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransactionDetailDTO> createTransactionDetail(@RequestBody TransactionDetailDTO transactionDetailDTO) {
        TransactionDetailDTO createdTransactionDetail = transactionDetailService.createTransactionDetail(transactionDetailDTO);
        return new ResponseEntity<>(createdTransactionDetail, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDetailDTO> updateTransactionDetail(@PathVariable("id") Long id, @RequestBody TransactionDetailDTO transactionDetailDTO) {
        transactionDetailDTO.setTransactionDetailID(id); // Set the ID in the DTO object
        TransactionDetailDTO updatedTransactionDetail = transactionDetailService.updateTransactionDetail(id, transactionDetailDTO); // Call service method with ID and DTO
        return new ResponseEntity<>(updatedTransactionDetail, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionDetail(@PathVariable("id") Long id) {
        transactionDetailService.deleteTransactionDetail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
