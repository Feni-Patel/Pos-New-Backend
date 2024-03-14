package org.pgs.postp.service;

import org.pgs.postp.dto.BarcodeDTO;

import java.util.List;

public interface BarcodeService {
    List<BarcodeDTO> getAllBarcodes();

    BarcodeDTO getBarcodeById(Long id);

    BarcodeDTO createBarcode(BarcodeDTO barcodeDTO);

    BarcodeDTO updateBarcode(Long id, BarcodeDTO barcodeDTO); // Change here

    void deleteBarcode(Long id);
}
