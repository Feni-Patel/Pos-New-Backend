package org.pgs.postp.service;

import org.pgs.postp.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDTO> getAllInvoices();

    InvoiceDTO getInvoiceById(Long id);

    InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);

    InvoiceDTO updateInvoice(Long id, InvoiceDTO invoiceDTO);

    void deleteInvoice(Long id);
}