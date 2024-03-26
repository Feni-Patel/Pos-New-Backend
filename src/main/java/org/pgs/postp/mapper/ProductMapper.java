package org.pgs.postp.mapper;

import org.pgs.postp.dto.ProductDTO;
import org.pgs.postp.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public static ProductDTO toDTO(ProductModel productModel) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productModel.getProductId());
        productDTO.setName(productModel.getName());
        productDTO.setDescription(productModel.getDescription());
        productDTO.setPrice(productModel.getPrice());
        productDTO.setTax(productModel.getTax());
        productDTO.setTotal(productModel.getTotal());
        productDTO.setStockQuantity(productModel.getStockQuantity());
        productDTO.setPurchasePrice(productModel.getPurchasePrice());
        productDTO.setBarcodeNumber(productModel.getBarcodeNumber());
        productDTO.setBarcodeImage(productModel.getBarcodeImage());
        productDTO.setSupplierIds(
                productModel.getSuppliers().stream()
                        .map(supplier -> supplier.getSupplierID())
                        .collect(Collectors.toList())
        );
        return productDTO;
    }

    public static ProductModel toEntity(ProductDTO productDTO) {
        // This method doesn't map the supplierIds to suppliers
        // As it depends on how you handle suppliers, you might need additional logic here
        ProductModel productModel = new ProductModel();
        productModel.setProductId(productDTO.getProductId());
        productModel.setName(productDTO.getName());
        productModel.setDescription(productDTO.getDescription());
        productModel.setPrice(productDTO.getPrice());
        productModel.setTax(productDTO.getTax());
        productModel.setTotal(productDTO.getTotal());
        productModel.setStockQuantity(productDTO.getStockQuantity());
        productModel.setPurchasePrice(productDTO.getPurchasePrice());
        productModel.setBarcodeNumber(productDTO.getBarcodeNumber());
        productModel.setBarcodeImage(productDTO.getBarcodeImage());
        return productModel;
    }

    public static List<ProductDTO> toDTOList(List<ProductModel> productModels) {
        return productModels.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<ProductModel> toEntityList(List<ProductDTO> productDTOs) {
        return productDTOs.stream()
                .map(ProductMapper::toEntity)
                .collect(Collectors.toList());
    }
}
