package org.pgs.postp.controller;

import org.pgs.postp.dto.CustomerPurchaseHistoryDTO;
import org.pgs.postp.service.CustomerPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-purchase-history")
public class CustomerPurchaseHistoryController {

    private final CustomerPurchaseHistoryService purchaseHistoryService;

    @Autowired
    public CustomerPurchaseHistoryController(CustomerPurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @PostMapping
    public ResponseEntity<CustomerPurchaseHistoryDTO> createPurchaseHistory(@RequestBody CustomerPurchaseHistoryDTO purchaseHistoryDTO) {
        CustomerPurchaseHistoryDTO createdPurchaseHistory = purchaseHistoryService.createPurchaseHistory(purchaseHistoryDTO);
        return new ResponseEntity<>(createdPurchaseHistory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerPurchaseHistoryDTO> getPurchaseHistoryById(@PathVariable("id") Long id) {
        CustomerPurchaseHistoryDTO purchaseHistoryDTO = purchaseHistoryService.getPurchaseHistoryById(id);
        return new ResponseEntity<>(purchaseHistoryDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerPurchaseHistoryDTO>> getAllPurchaseHistory() {
        List<CustomerPurchaseHistoryDTO> purchaseHistoryDTOs = purchaseHistoryService.getAllPurchaseHistory();
        return new ResponseEntity<>(purchaseHistoryDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerPurchaseHistoryDTO> updatePurchaseHistory(@PathVariable("id") Long id, @RequestBody CustomerPurchaseHistoryDTO purchaseHistoryDTO) {
        purchaseHistoryDTO.setPurchaseID(id);
        CustomerPurchaseHistoryDTO updatedPurchaseHistory = purchaseHistoryService.updatePurchaseHistory(id, purchaseHistoryDTO);
        return new ResponseEntity<>(updatedPurchaseHistory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseHistory(@PathVariable("id") Long id) {
        purchaseHistoryService.deletePurchaseHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
