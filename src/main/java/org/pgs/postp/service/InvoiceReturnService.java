package org.pgs.postp.service;

import org.pgs.postp.dto.InvoiceReturnDTO;

import java.util.List;

public interface InvoiceReturnService {
    List<InvoiceReturnDTO> getAllInvoiceReturns();

    InvoiceReturnDTO getInvoiceReturnById(Long id);

    InvoiceReturnDTO createInvoiceReturn(InvoiceReturnDTO invoiceReturnDTO);

    InvoiceReturnDTO updateInvoiceReturn(Long id, InvoiceReturnDTO invoiceReturnDTO);

    void deleteInvoiceReturn(Long id);
}
