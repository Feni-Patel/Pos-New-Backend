package org.pgs.postp.mapper;

import org.pgs.postp.dto.CustomerDTO;
import org.pgs.postp.model.CustomerModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerModel.getId());
        customerDTO.setName(customerModel.getName());
        customerDTO.setEmail(customerModel.getEmail());
        customerDTO.setPhone(customerModel.getPhone());
        customerDTO.setAddress(customerModel.getAddress());
        // You may also need to map transactions if required
        return customerDTO;
    }

    public CustomerModel toEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customerDTO.getId());
        customerModel.setName(customerDTO.getName());
        customerModel.setEmail(customerDTO.getEmail());
        customerModel.setPhone(customerDTO.getPhone());
        customerModel.setAddress(customerDTO.getAddress());
        // You may also need to map transactions if required
        return customerModel;
    }
}
