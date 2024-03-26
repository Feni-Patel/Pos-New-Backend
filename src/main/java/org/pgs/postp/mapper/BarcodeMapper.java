package org.pgs.postp.mapper;

import org.pgs.postp.dto.BarcodeDTO;
import org.pgs.postp.model.BarcodeModel;
import org.springframework.stereotype.Component;

@Component
public class BarcodeMapper {

    public BarcodeDTO toDTO(BarcodeModel barcodeModel) {
        if (barcodeModel == null) {
            return null;
        }
        BarcodeDTO barcodeDTO = new BarcodeDTO();
        barcodeDTO.setId(barcodeModel.getBarcodeID());
        barcodeDTO.setBarcodeNumber(barcodeModel.getBarcodeNumber());
        barcodeDTO.setBarcodeImage(barcodeModel.getBarcodeImage());
        // Assuming product is set via ProductModel object in BarcodeModel
//        if (barcodeModel.getProduct() != null) {
//            barcodeDTO.setProductId(barcodeModel.getProduct().getProductId());
//        }
        return barcodeDTO;
    }

    public BarcodeModel toEntity(BarcodeDTO barcodeDTO) {
        if (barcodeDTO == null) {
            return null;
        }
        BarcodeModel barcodeModel = new BarcodeModel();
        barcodeModel.setBarcodeID(barcodeDTO.getId());
        barcodeModel.setBarcodeNumber(barcodeDTO.getBarcodeNumber());
        barcodeModel.setBarcodeImage(barcodeDTO.getBarcodeImage());
        // Assuming productId is set via ProductModel object in BarcodeModel
//        if (barcodeDTO.getProductId() != null) {
//            ProductModel product = new ProductModel();
//            product.setProductId(barcodeDTO.getProductId());
//            barcodeModel.setProduct(product);
//        }
        return barcodeModel;
    }
}