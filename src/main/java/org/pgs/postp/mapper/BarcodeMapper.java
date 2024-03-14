package org.pgs.postp.mapper;

import org.pgs.postp.dto.BarcodeDTO;
import org.pgs.postp.model.BarcodeModel;
import org.pgs.postp.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class BarcodeMapper {

    public BarcodeDTO toDTO(BarcodeModel barcodeModel) {
        if (barcodeModel == null) {
            return null;
        }
        BarcodeDTO barcodeDTO = new BarcodeDTO();
        barcodeDTO.setId(barcodeModel.getBarcodeID()); // Corrected method name to match the field name
        barcodeDTO.setBarcodeNumber(barcodeModel.getBarcodeNumber());
        // Assuming product is set via ProductModel object in BarcodeModel
        if (barcodeModel.getProduct() != null) {
            barcodeDTO.setProductId(barcodeModel.getProduct().getProductId());
        }
        return barcodeDTO;
    }

    public BarcodeModel toEntity(BarcodeDTO barcodeDTO) {
        if (barcodeDTO == null) {
            return null;
        }
        BarcodeModel barcodeModel = new BarcodeModel();
        barcodeModel.setBarcodeID(barcodeDTO.getId()); // Corrected method name to match the field name
        barcodeModel.setBarcodeNumber(barcodeDTO.getBarcodeNumber());
        // Assuming productId is set via ProductModel object in BarcodeModel
        if (barcodeDTO.getProductId() != null) {
            ProductModel product = new ProductModel();
            product.setProductId(barcodeDTO.getProductId());
            barcodeModel.setProduct(product);
        }
        return barcodeModel;
    }
}
