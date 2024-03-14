package org.pgs.postp.mapper;

import org.pgs.postp.dto.InvoiceDTO;
import org.pgs.postp.model.InvoiceModel;
import org.pgs.postp.model.SupplierModel;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    public InvoiceDTO toDTO(InvoiceModel invoiceModel) {
        if (invoiceModel == null) {
            return null;
        }
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setInvoiceID(invoiceModel.getInvoiceID());
        invoiceDTO.setSupplierId(invoiceModel.getSupplier().getSupplierID());
        invoiceDTO.setTotalAmount(invoiceModel.getTotalAmount());
        invoiceDTO.setDueDate(invoiceModel.getDueDate());
        invoiceDTO.setStatus(invoiceModel.getStatus());
        return invoiceDTO;
    }

    public InvoiceModel toEntity(InvoiceDTO invoiceDTO) {
        if (invoiceDTO == null) {
            return null;
        }
        InvoiceModel invoiceModel = new InvoiceModel();
        invoiceModel.setInvoiceID(invoiceDTO.getInvoiceID());
        // Assuming supplierId is set via SupplierModel object in InvoiceModel
        if (invoiceDTO.getSupplierId() != null) {
            SupplierModel supplier = new SupplierModel();
            supplier.setSupplierID(invoiceDTO.getSupplierId());
            invoiceModel.setSupplier(supplier);
        }
        invoiceModel.setTotalAmount(invoiceDTO.getTotalAmount());
        invoiceModel.setDueDate(invoiceDTO.getDueDate());
        invoiceModel.setStatus(invoiceDTO.getStatus());
        return invoiceModel;
    }
}
