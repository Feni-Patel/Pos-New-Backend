package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.SupplierDTO;
import org.pgs.postp.mapper.SupplierMapper;
import org.pgs.postp.model.ProductModel;
import org.pgs.postp.model.SupplierModel;
import org.pgs.postp.repository.SupplierRepository;
import org.pgs.postp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<SupplierModel> suppliers = supplierRepository.findAll();
        return suppliers.stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDTO getSupplierById(Long id) {
        SupplierModel supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
        return supplierMapper.toDTO(supplier);
    }

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        SupplierModel supplier = supplierMapper.toEntity(supplierDTO);
        SupplierModel savedSupplier = supplierRepository.save(supplier);
        return supplierMapper.toDTO(savedSupplier);
    }

    @Override
    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
        SupplierModel existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
        if(supplierDTO.getSupplierAgency()!=null){
            existingSupplier.setSupplierAgency(supplierDTO.getSupplierAgency());
        }
        if(supplierDTO.getContactPerson()!=null){
            existingSupplier.setContactPerson(supplierDTO.getContactPerson());
        }
        if(supplierDTO.getSupplierEmail()!=null){
            existingSupplier.setSupplierEmail(supplierDTO.getSupplierEmail());
        }
        if(supplierDTO.getSupplierPhone()!=null){
            existingSupplier.setSupplierPhone(supplierDTO.getSupplierPhone());
        }
        if(supplierDTO.getContactPersonEmail()!=null){
            existingSupplier.setContactPersonEmail(supplierDTO.getContactPersonEmail());
        }
        if(supplierDTO.getContactPersonPhone()!=null){
            existingSupplier.setContactPersonPhone(supplierDTO.getContactPersonPhone());
        }
        if(supplierDTO.getAddress() != null){
            existingSupplier.setAddress(supplierDTO.getAddress());
        }
        // Update properties here
        SupplierModel updatedSupplier = supplierRepository.save(existingSupplier);
        return supplierMapper.toDTO(updatedSupplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new RuntimeException("Supplier not found with id: " + id);
        }
        supplierRepository.deleteById(id);
    }

    public void processCSV(MultipartFile file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));

        // Skip the header line
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String supplierAgency = data[0].trim();
            String contactPerson = data[1].trim();
            String supplierEmail = data[2].trim();
            BigInteger supplierPhone = new BigInteger(data[3].trim());
            String contactPersonEmail = data[4].trim();
            BigInteger contactPersonPhone = new BigInteger(data[5].trim());
            String address = data[6].trim();

            SupplierModel supplier = new SupplierModel();
            supplier.setSupplierAgency(supplierAgency);
            supplier.setContactPerson(contactPerson);
            supplier.setSupplierEmail(supplierEmail);
            supplier.setSupplierPhone(supplierPhone);
            supplier.setContactPersonEmail(contactPersonEmail);
            supplier.setContactPersonPhone(contactPersonPhone);
            supplier.setAddress(address);
            supplierRepository.save(supplier);
        }
        br.close();
    }
}