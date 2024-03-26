package org.pgs.postp.controller;

import com.google.zxing.WriterException;
import org.pgs.postp.dto.CustomerDTO;
import org.pgs.postp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin( origins = "http://Localhost:4200")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerDTOs = customerService.getAllCustomers();
        return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(id);
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile file) {
        try {
            customerService.processCSV(file);
            return ResponseEntity.status(HttpStatus.OK).body("CSV processed successfully");
        } catch (IOException | WriterException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process CSV: " + e.getMessage());
        }
    }

}