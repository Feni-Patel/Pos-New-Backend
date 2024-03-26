package org.pgs.postp.service.Impl;


import org.pgs.postp.dto.InvoiceDTO;
import org.pgs.postp.mapper.InvoiceMapper;
import org.pgs.postp.model.InvoiceModel;
import org.pgs.postp.repository.InvoiceRepository;
import org.pgs.postp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;


    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        List<InvoiceModel> invoices = invoiceRepository.findAll();
        return invoices.stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDTO getInvoiceById(Long id) {
        InvoiceModel invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
        return invoiceMapper.toDTO(invoice);
    }

    @Override
    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        InvoiceModel invoice = invoiceMapper.toEntity(invoiceDTO);
        calculateTotalPrice(invoice);
        InvoiceModel savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDTO(savedInvoice);
    }

    @Override
    public InvoiceDTO updateInvoice(Long id, InvoiceDTO invoiceDTO) {
        InvoiceModel existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));

        if (invoiceDTO.getDateTime() != null) {
            existingInvoice.setDateTime(invoiceDTO.getDateTime());
        }
        if (invoiceDTO.getProducts() != null) {
            existingInvoice.setProducts(invoiceDTO.getProducts());
        }
        if (invoiceDTO.getPaymentMethod() != null) {
            existingInvoice.setPaymentMethod(invoiceDTO.getPaymentMethod());
        }
        if (invoiceDTO.getBarcodeID() != null) {
            existingInvoice.setBarcodeID(invoiceDTO.getBarcodeID());
        }
        if (invoiceDTO.getBarcodeNumbers() != null) {
            existingInvoice.setBarcodeNumbers(invoiceDTO.getBarcodeNumbers());
        }
        if (invoiceDTO.getCustomerName() != null) {
            existingInvoice.setCustomerName(invoiceDTO.getCustomerName());
        }
        if (invoiceDTO.getCustomerPhone() != null) {
            existingInvoice.setCustomerPhone(invoiceDTO.getCustomerPhone());
        }
        if (invoiceDTO.getVoucher() != null) {
            existingInvoice.setVoucher(invoiceDTO.getVoucher());
        }
        if (invoiceDTO.getTotalMRP() != null) {
            existingInvoice.setTotalMRP(invoiceDTO.getTotalMRP());
        }
        if (invoiceDTO.getTotalTax() != null) {
            existingInvoice.setTotalTax(invoiceDTO.getTotalTax());
        }
        if (invoiceDTO.getTotalDiscount() != null) {
            existingInvoice.setTotalDiscount(invoiceDTO.getTotalDiscount());
        }
        if (invoiceDTO.getTotalPrice() != null) {
            existingInvoice.setTotalPrice(invoiceDTO.getTotalPrice());
        }

        if(invoiceDTO.getStatus()!=null){
            existingInvoice.setStatus(invoiceDTO.getStatus());
        }

        // Calculate total price
        calculateTotalPrice(existingInvoice);

        // Update properties here
        InvoiceModel updatedInvoice = invoiceRepository.save(existingInvoice);
        return invoiceMapper.toDTO(updatedInvoice);
    }

    private void calculateTotalPrice(InvoiceModel invoice) {
        long totalMRP = invoice.getTotalMRP() != null ? invoice.getTotalMRP() : 0;
        long totalTax = invoice.getTotalTax() != null ? invoice.getTotalTax() : 0;
        long totalDiscount = invoice.getTotalDiscount() != null ? invoice.getTotalDiscount() : 0;

        // Calculate total price
        long totalPrice = totalMRP + totalTax - totalDiscount;
        invoice.setTotalPrice(totalPrice);
    }

    @Override
    public void deleteInvoice(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new RuntimeException("Invoice not found with id: " + id);
        }
        invoiceRepository.deleteById(id);
    }
}