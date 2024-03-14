package org.pgs.postp.controller;

import org.pgs.postp.dto.BarcodeDTO;
import org.pgs.postp.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barcodes")
public class BarcodeController {

    private final BarcodeService barcodeService;

    @Autowired
    public BarcodeController(BarcodeService barcodeService) {
        this.barcodeService = barcodeService;
    }

    @PostMapping
    public ResponseEntity<BarcodeDTO> createBarcode(@RequestBody BarcodeDTO barcodeDTO) {
        BarcodeDTO createdBarcode = barcodeService.createBarcode(barcodeDTO);
        return new ResponseEntity<>(createdBarcode, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarcodeDTO> getBarcodeById(@PathVariable("id") Long id) {
        BarcodeDTO barcodeDTO = barcodeService.getBarcodeById(id);
        return new ResponseEntity<>(barcodeDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BarcodeDTO>> getAllBarcodes() {
        List<BarcodeDTO> barcodeDTOs = barcodeService.getAllBarcodes();
        return new ResponseEntity<>(barcodeDTOs, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BarcodeDTO> updateBarcode(@PathVariable("id") Long id, @RequestBody BarcodeDTO barcodeDTO) {
        barcodeDTO.setId(id); // Set the ID in the DTO object
        BarcodeDTO updatedBarcode = barcodeService.updateBarcode(id, barcodeDTO); // Call service method with ID and DTO
        return new ResponseEntity<>(updatedBarcode, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarcode(@PathVariable("id") Long id) {
        barcodeService.deleteBarcode(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
