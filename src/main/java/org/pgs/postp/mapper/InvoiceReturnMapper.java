package org.pgs.postp.mapper;

import org.pgs.postp.model.InvoiceModel;
import org.pgs.postp.model.InvoiceReturnModel;
import org.pgs.postp.dto.InvoiceReturnDTO;
import org.springframework.stereotype.Component;

@Component
public class InvoiceReturnMapper {

    // Convert InvoiceReturnModel to InvoiceReturnDTO
    public InvoiceReturnDTO toDTO(InvoiceReturnModel model) {
        InvoiceReturnDTO dto = new InvoiceReturnDTO();
        dto.setReturnID(model.getReturnID());
        dto.setInvoiceID(model.getInvoice().getInvoiceID()); // Assuming you have a method to get invoice ID from InvoiceModel
        dto.setReturnDate(model.getReturnDate());
        dto.setReturnReason(model.getReturnReason());
        dto.setRefundAmount(model.getRefundAmount());
        return dto;
    }

    // Convert InvoiceReturnDTO to InvoiceReturnModel
    public static InvoiceReturnModel toModel(InvoiceReturnDTO dto) {
        InvoiceReturnModel model = new InvoiceReturnModel();
        // You might need to fetch InvoiceModel from database based on the ID in the DTO
        // and then set it to the model object
        model.setReturnID(dto.getReturnID());
        // Set InvoiceModel
        model.setReturnDate(dto.getReturnDate());
        model.setReturnReason(dto.getReturnReason());
        model.setRefundAmount(dto.getRefundAmount());
        return model;
    }

    public InvoiceReturnModel toEntity(InvoiceReturnDTO invoiceReturnDTO) {
        if (invoiceReturnDTO == null) {
            return null;
        }
        InvoiceReturnModel invoiceReturnModel = new InvoiceReturnModel();
        invoiceReturnModel.setReturnID(invoiceReturnDTO.getReturnID());
        // Assuming invoice ID is set via InvoiceModel object
        if (invoiceReturnDTO.getInvoiceID() != null) {
            InvoiceModel invoice = new InvoiceModel();
            invoice.setInvoiceID(invoiceReturnDTO.getInvoiceID());
            invoiceReturnModel.setInvoice(invoice);
        }
        invoiceReturnModel.setReturnDate(invoiceReturnDTO.getReturnDate());
        // You can map other fields here if needed
        return invoiceReturnModel;
    }

}
