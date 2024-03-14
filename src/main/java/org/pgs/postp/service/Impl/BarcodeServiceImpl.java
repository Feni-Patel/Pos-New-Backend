package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.BarcodeDTO;
import org.pgs.postp.mapper.BarcodeMapper;
import org.pgs.postp.model.BarcodeModel;
import org.pgs.postp.repository.BarcodeRepository;
import org.pgs.postp.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarcodeServiceImpl implements BarcodeService {

    private final BarcodeRepository barcodeRepository;
    private final BarcodeMapper barcodeMapper;

    @Autowired
    public BarcodeServiceImpl(BarcodeRepository barcodeRepository, BarcodeMapper barcodeMapper) {
        this.barcodeRepository = barcodeRepository;
        this.barcodeMapper = barcodeMapper;
    }

    @Override
    public List<BarcodeDTO> getAllBarcodes() {
        List<BarcodeModel> barcodes = barcodeRepository.findAll();
        return barcodes.stream()
                .map(barcodeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BarcodeDTO getBarcodeById(Long id) {
        BarcodeModel barcode = barcodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barcode not found with id: " + id));
        return barcodeMapper.toDTO(barcode);
    }

    @Override
    public BarcodeDTO createBarcode(BarcodeDTO barcodeDTO) {
        BarcodeModel barcode = barcodeMapper.toEntity(barcodeDTO);
        BarcodeModel savedBarcode = barcodeRepository.save(barcode);
        return barcodeMapper.toDTO(savedBarcode);
    }

    @Override
    public BarcodeDTO updateBarcode(Long id, BarcodeDTO barcodeDTO) {
        // Check if the barcode with the given ID exists
        BarcodeModel existingBarcode = barcodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barcode not found with id: " + id));

        // Update the properties of the existing BarcodeModel with the data from barcodeDTO
        existingBarcode.setBarcodeNumber(barcodeDTO.getBarcodeNumber());
        // Update other properties as needed

        // Save the updated BarcodeModel
        BarcodeModel updatedBarcode = barcodeRepository.save(existingBarcode);

        // Map the updated BarcodeModel to a BarcodeDTO and return it
        return barcodeMapper.toDTO(updatedBarcode);
    }

    @Override
    public void deleteBarcode(Long id) {
        if (!barcodeRepository.existsById(id)) {
            throw new RuntimeException("Barcode not found with id: " + id);
        }
        barcodeRepository.deleteById(id);
    }
}
