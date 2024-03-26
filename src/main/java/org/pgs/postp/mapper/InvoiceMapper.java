package org.pgs.postp.mapper;

import org.pgs.postp.dto.InvoiceDTO;
import org.pgs.postp.model.InvoiceModel;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    public InvoiceDTO toDTO(InvoiceModel invoiceModel) {
        if (invoiceModel == null) {
            return null;
        }
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setInvoiceID(invoiceModel.getInvoiceID());
        invoiceDTO.setDateTime(invoiceModel.getDateTime());
        invoiceDTO.setProducts(invoiceModel.getProducts());
        invoiceDTO.setPaymentMethod(invoiceModel.getPaymentMethod());
        invoiceDTO.setBarcodeID(invoiceModel.getBarcodeID());
        invoiceDTO.setBarcodeNumbers(invoiceModel.getBarcodeNumbers());
        invoiceDTO.setCustomerName(invoiceModel.getCustomerName());
        invoiceDTO.setCustomerPhone(invoiceModel.getCustomerPhone());
        invoiceDTO.setVoucher(invoiceModel.getVoucher());
        invoiceDTO.setTotalMRP(invoiceModel.getTotalMRP());
        invoiceDTO.setTotalTax(invoiceModel.getTotalTax());
        invoiceDTO.setTotalDiscount(invoiceModel.getTotalDiscount());
        invoiceDTO.setTotalPrice(invoiceModel.getTotalPrice());
        invoiceDTO.setStatus(invoiceModel.getStatus());
        return invoiceDTO;
    }

    public InvoiceModel toEntity(InvoiceDTO invoiceDTO) {
        if (invoiceDTO == null) {
            return null;
        }
        InvoiceModel invoiceModel = new InvoiceModel();
        invoiceModel.setInvoiceID(invoiceDTO.getInvoiceID());
        invoiceModel.setDateTime(invoiceDTO.getDateTime());
        invoiceModel.setProducts(invoiceDTO.getProducts());
        invoiceModel.setPaymentMethod(invoiceDTO.getPaymentMethod());
        invoiceModel.setBarcodeID(invoiceDTO.getBarcodeID());
        invoiceModel.setBarcodeNumbers(invoiceDTO.getBarcodeNumbers());
        invoiceModel.setCustomerName(invoiceDTO.getCustomerName());
        invoiceModel.setCustomerPhone(invoiceDTO.getCustomerPhone());
        invoiceModel.setVoucher(invoiceDTO.getVoucher());
        invoiceModel.setTotalMRP(invoiceDTO.getTotalMRP());
        invoiceModel.setTotalTax(invoiceDTO.getTotalTax());
        invoiceModel.setTotalDiscount(invoiceDTO.getTotalDiscount());
        invoiceModel.setTotalPrice(invoiceDTO.getTotalPrice());
        invoiceModel.setStatus(invoiceDTO.getStatus());
        return invoiceModel;
    }
}