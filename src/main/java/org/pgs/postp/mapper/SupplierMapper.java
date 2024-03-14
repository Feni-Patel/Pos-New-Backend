package org.pgs.postp.mapper;

import org.pgs.postp.model.SupplierModel;
import org.pgs.postp.dto.SupplierDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SupplierMapper {

    // Convert SupplierModel to SupplierDTO
    public SupplierDTO toDTO(SupplierModel model) {
        SupplierDTO dto = new SupplierDTO();
        dto.setSupplierID(model.getSupplierID());
        dto.setName(model.getName());
        dto.setEmail(model.getEmail());
        dto.setPhone(model.getPhone());
        // You might choose to map the list of products here, depending on your requirements
        return dto;
    }

    // Convert SupplierDTO to SupplierModel
    public static SupplierModel toModel(SupplierDTO dto) {
        SupplierModel model = new SupplierModel();
        model.setSupplierID(dto.getSupplierID());
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());
        // You might choose to map the list of products here, depending on your requirements
        return model;
    }

    public SupplierModel toEntity(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return null;
        }
        SupplierModel supplierModel = new SupplierModel();
        supplierModel.setSupplierID(supplierDTO.getSupplierID());
        supplierModel.setName(supplierDTO.getName());
        supplierModel.setEmail(supplierDTO.getEmail());
        supplierModel.setPhone(supplierDTO.getPhone());
        return supplierModel;
    }

}
