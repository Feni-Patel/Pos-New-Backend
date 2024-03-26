package org.pgs.postp.service;

import com.google.zxing.WriterException;
import org.pgs.postp.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO getProductByBarcodeNumber(String barcodeNumber);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void processCSV(MultipartFile file) throws IOException,WriterException;
    void deleteProduct(Long id);

}