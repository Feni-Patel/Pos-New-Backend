package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.TaxDTO;
import org.pgs.postp.mapper.TaxMapper;
import org.pgs.postp.model.TaxModel;
import org.pgs.postp.repository.TaxRepository;
import org.pgs.postp.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxServiceImpl implements TaxService {

    private final TaxRepository taxRepository;
    private final TaxMapper taxMapper;

    @Autowired
    public TaxServiceImpl(TaxRepository taxRepository, TaxMapper taxMapper) {
        this.taxRepository = taxRepository;
        this.taxMapper = taxMapper;
    }

    @Override
    public List<TaxDTO> getAllTaxes() {
        List<TaxModel> taxes = taxRepository.findAll();
        return taxes.stream()
                .map(taxMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaxDTO getTaxById(Long id) {
        TaxModel tax = taxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tax not found with id: " + id));
        return taxMapper.toDTO(tax);
    }

    @Override
    public TaxDTO createTax(TaxDTO taxDTO) {
        TaxModel tax = taxMapper.toEntity(taxDTO);
        TaxModel savedTax = taxRepository.save(tax);
        return taxMapper.toDTO(savedTax);
    }

    @Override
    public TaxDTO updateTax(Long id, TaxDTO taxDTO) {
        TaxModel existingTax = taxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tax not found with id: " + id));
        // Update properties here
        TaxModel updatedTax = taxRepository.save(existingTax);
        return taxMapper.toDTO(updatedTax);
    }

    @Override
    public void deleteTax(Long id) {
        if (!taxRepository.existsById(id)) {
            throw new RuntimeException("Tax not found with id: " + id);
        }
        taxRepository.deleteById(id);
    }
}
