package org.pgs.postp.controller;

import com.google.zxing.WriterException;
import org.pgs.postp.dto.SupplierDTO;
import org.pgs.postp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin( origins = "http://Localhost:4200")

public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        SupplierDTO createdSupplier = supplierService.createSupplier(supplierDTO);
        return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            supplierService.processCSV(file);
            return ResponseEntity.status(HttpStatus.OK).body("CSV processed successfully");
        } catch (IOException | WriterException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process CSV: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable("id") Long id) {
        SupplierDTO supplierDTO = supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplierDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> supplierDTOs = supplierService.getAllSuppliers();
        return new ResponseEntity<>(supplierDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable("id") Long id, @RequestBody SupplierDTO supplierDTO) {
        supplierDTO.setSupplierID(id);
        SupplierDTO updatedSupplier = supplierService.updateSupplier(id, supplierDTO);
        return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Long id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
