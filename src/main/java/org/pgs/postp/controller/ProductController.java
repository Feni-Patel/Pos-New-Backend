package org.pgs.postp.controller;

import com.google.zxing.WriterException;
import org.pgs.postp.dto.ProductDTO;
import org.pgs.postp.service.Impl.ProductServiceImpl;
import org.pgs.postp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin( origins = "http://Localhost:4200")
public class ProductController {

    private final ProductService productService;
    private final ProductServiceImpl productServiceImpl;
    @Autowired
    public ProductController(ProductService productService, ProductServiceImpl productServiceImpl) {
        this.productService = productService;
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            productService.processCSV(file);
            return ResponseEntity.status(HttpStatus.OK).body("CSV processed successfully");
        } catch (IOException | WriterException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process CSV: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
        ProductDTO productDTO = productService.getProductById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOs = productService.getAllProducts();
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @GetMapping("/barcode-number/{barcodeNumber}")
    public ResponseEntity<ProductDTO> getProductByBarcodeNumber(@PathVariable("barcodeNumber") String barcodeNumber) {
        ProductDTO productDTO = productService.getProductByBarcodeNumber(barcodeNumber);
        if (productDTO != null) {
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product-barcode/{id}")
    public ResponseEntity<byte[]> getBarcode(@PathVariable String id) {

        try {
            byte[] barcodeBytes = productServiceImpl.generateBarcode(id, 200, 50); // Adjust width and height as needed
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(barcodeBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setProductId(id);
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}