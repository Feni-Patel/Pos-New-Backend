package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.CustomerDTO;
import org.pgs.postp.mapper.CustomerMapper;
import org.pgs.postp.model.CustomerModel;
import org.pgs.postp.model.ProductModel;
import org.pgs.postp.repository.CustomerRepository;
import org.pgs.postp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerModel> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        CustomerModel customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerModel customer = customerMapper.toEntity(customerDTO);
        CustomerModel savedCustomer = customerRepository.save(customer);
        return customerMapper.toDTO(savedCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        CustomerModel existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        if(customerDTO.getName()!=null){
            existingCustomer.setName(customerDTO.getName());
        }
        if(customerDTO.getEmail()!=null){
            existingCustomer.setEmail(customerDTO.getEmail());
        }
        if(customerDTO.getPhone()!=null){
            existingCustomer.setPhone(customerDTO.getPhone());
        }
        if(customerDTO.getAddress()!=null){
            existingCustomer.setAddress(customerDTO.getAddress());
        }
//        existingCustomer.setName(customerDTO.getName());
//        existingCustomer.setEmail(customerDTO.getEmail());
//        existingCustomer.setPhone(customerDTO.getPhone());
        CustomerModel updatedCustomer = customerRepository.save(existingCustomer);
        return customerMapper.toDTO(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }

    public void processCSV(MultipartFile file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));

        // Skip the header line
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String name = data[0].trim();
            String email = data[1].trim();
            BigInteger phone = new BigInteger(data[2].trim());
            String address = data[3].trim();


            CustomerModel customerModel = new CustomerModel();
            customerModel.setName(name);
            customerModel.setEmail(email);
            customerModel.setPhone(phone);
            customerModel.setAddress(address);

            customerRepository.save(customerModel);
        }
        br.close();
    }


}