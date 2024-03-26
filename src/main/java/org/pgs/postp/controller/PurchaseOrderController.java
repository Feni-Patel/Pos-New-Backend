package org.pgs.postp.controller;

import org.pgs.postp.dto.PurchaseOrderDTO;
import org.pgs.postp.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchaseOrders")
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderDTO> createPurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        PurchaseOrderDTO createdPurchaseOrder = purchaseOrderService.createPurchaseOrder(purchaseOrderDTO);
        return new ResponseEntity<>(createdPurchaseOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderDTO> getPurchaseOrderById(@PathVariable("id") Long id) {
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderService.getPurchaseOrderById(id);
        return new ResponseEntity<>(purchaseOrderDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderDTO>> getAllPurchaseOrders() {
        List<PurchaseOrderDTO> purchaseOrderDTOs = purchaseOrderService.getAllPurchaseOrders();
        return new ResponseEntity<>(purchaseOrderDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderDTO> updatePurchaseOrder(@PathVariable("id") Long id, @RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        purchaseOrderDTO.setId(id);
        PurchaseOrderDTO updatedPurchaseOrder = purchaseOrderService.updatePurchaseOrder(id, purchaseOrderDTO);
        return new ResponseEntity<>(updatedPurchaseOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable("id") Long id) {
        purchaseOrderService.deletePurchaseOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}