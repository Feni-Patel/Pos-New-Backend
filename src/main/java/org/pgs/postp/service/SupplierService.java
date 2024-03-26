package org.pgs.postp.service;

import com.google.zxing.WriterException;
import org.pgs.postp.dto.SupplierDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
    List<SupplierDTO> getAllSuppliers();

    SupplierDTO getSupplierById(Long id);

    SupplierDTO createSupplier(SupplierDTO supplierDTO);

    SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO);

    void processCSV(MultipartFile file) throws IOException, WriterException;

    void deleteSupplier(Long id);
}
