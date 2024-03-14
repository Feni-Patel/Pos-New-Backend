package org.pgs.postp.controller;

import org.pgs.postp.dto.TaxDTO;
import org.pgs.postp.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {

    private final TaxService taxService;

    @Autowired
    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping
    public ResponseEntity<TaxDTO> createTax(@RequestBody TaxDTO taxDTO) {
        TaxDTO createdTax = taxService.createTax(taxDTO);
        return new ResponseEntity<>(createdTax, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxDTO> getTaxById(@PathVariable("id") Long id) {
        TaxDTO taxDTO = taxService.getTaxById(id);
        return new ResponseEntity<>(taxDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaxDTO>> getAllTaxes() {
        List<TaxDTO> taxDTOs = taxService.getAllTaxes();
        return new ResponseEntity<>(taxDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaxDTO> updateTax(@PathVariable("id") Long id, @RequestBody TaxDTO taxDTO) {
        taxDTO.setTaxID(id);
        TaxDTO updatedTax = taxService.updateTax(id, taxDTO);
        return new ResponseEntity<>(updatedTax, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTax(@PathVariable("id") Long id) {
        taxService.deleteTax(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
