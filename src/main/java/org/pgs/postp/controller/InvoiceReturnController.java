package org.pgs.postp.controller;

import org.pgs.postp.dto.InvoiceReturnDTO;
import org.pgs.postp.service.InvoiceReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-returns")
@CrossOrigin( origins = "http://Localhost:4200")

public class InvoiceReturnController {

    private final InvoiceReturnService invoiceReturnService;

    @Autowired
    public InvoiceReturnController(InvoiceReturnService invoiceReturnService) {
        this.invoiceReturnService = invoiceReturnService;
    }

    @PostMapping
    public ResponseEntity<InvoiceReturnDTO> createInvoiceReturn(@RequestBody InvoiceReturnDTO invoiceReturnDTO) {
        InvoiceReturnDTO createdInvoiceReturn = invoiceReturnService.createInvoiceReturn(invoiceReturnDTO);
        return new ResponseEntity<>(createdInvoiceReturn, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceReturnDTO> getInvoiceReturnById(@PathVariable("id") Long id) {
        InvoiceReturnDTO invoiceReturnDTO = invoiceReturnService.getInvoiceReturnById(id);
        return new ResponseEntity<>(invoiceReturnDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceReturnDTO>> getAllInvoiceReturns() {
        List<InvoiceReturnDTO> invoiceReturnDTOs = invoiceReturnService.getAllInvoiceReturns();
        return new ResponseEntity<>(invoiceReturnDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceReturnDTO> updateInvoiceReturn(@PathVariable("id") Long id, @RequestBody InvoiceReturnDTO invoiceReturnDTO) {
        invoiceReturnDTO.setReturnID(id);
        InvoiceReturnDTO updatedInvoiceReturn = invoiceReturnService.updateInvoiceReturn(id, invoiceReturnDTO);
        return new ResponseEntity<>(updatedInvoiceReturn, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceReturn(@PathVariable("id") Long id) {
        invoiceReturnService.deleteInvoiceReturn(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
