package org.pgs.postp.service.Impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.pgs.postp.dto.BarcodeDTO;
import org.pgs.postp.mapper.BarcodeMapper;
import org.pgs.postp.model.BarcodeModel;
import org.pgs.postp.repository.BarcodeRepository;
import org.pgs.postp.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BarcodeServiceImpl implements BarcodeService {

    private final BarcodeRepository barcodeRepository;
    private final BarcodeMapper barcodeMapper;


    @Autowired
    public BarcodeServiceImpl(BarcodeRepository barcodeRepository, BarcodeMapper barcodeMapper) {
        this.barcodeRepository = barcodeRepository;
//        this.productRepository = productRepository;
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

//    @Override
//    public BarcodeDTO createBarcode(BarcodeDTO barcodeDTO) {
//        if (barcodeDTO.getProductId() == null) {
//            throw new IllegalArgumentException("Product ID must be provided");
//        }
//
//        // Fetch the product from the database
//        ProductModel product = productRepository.findById(barcodeDTO.getProductId())
//                .orElseThrow(() -> new RuntimeException("Product not found with id: " + barcodeDTO.getProductId()));
//
//        // Create the BarcodeModel entity and set the product
//        BarcodeModel barcode = new BarcodeModel(
//                null, // ID will be automatically generated
//                product,
//                barcodeDTO.getBarcodeNumber());
//
//        // Save the barcode to the database
//        BarcodeModel savedBarcode = barcodeRepository.save(barcode);
//        return barcodeMapper.toDTO(savedBarcode);
//    }



    @Override
    public BarcodeDTO updateBarcode(Long id, BarcodeDTO barcodeDTO) {
        // Check if the barcode with the given ID exists
        BarcodeModel existingBarcode = barcodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barcode not found with id: " + id));
        if(barcodeDTO.getBarcodeNumber()!=null){
            existingBarcode.setBarcodeNumber(barcodeDTO.getBarcodeNumber());
        }

        if (barcodeDTO.getBarcodeImage() != null) {
            existingBarcode.setBarcodeImage(barcodeDTO.getBarcodeImage());
        }

        // Update the properties of the existing BarcodeModel with the data from barcodeDTO
//        existingBarcode.setBarcodeNumber(barcodeDTO.getBarcodeNumber());
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

    public byte[] generateBarcode(String barcodeText, int width, int height) throws WriterException, IOException {
        // Set barcode parameters
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 0); // Set margin to 0
        BitMatrix bitMatrix = new MultiFormatWriter().encode(barcodeText, BarcodeFormat.CODE_128, width, height, hints);

        // Convert bitMatrix to byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        return outputStream.toByteArray();
    }
}