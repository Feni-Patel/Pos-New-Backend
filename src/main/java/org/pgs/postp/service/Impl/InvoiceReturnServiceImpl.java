package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.InvoiceReturnDTO;
import org.pgs.postp.mapper.InvoiceReturnMapper;
import org.pgs.postp.model.InvoiceModel;
import org.pgs.postp.model.InvoiceReturnModel;
import org.pgs.postp.repository.InvoiceRepository;
import org.pgs.postp.repository.InvoiceReturnRepository;
import org.pgs.postp.service.InvoiceReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceReturnServiceImpl implements InvoiceReturnService {

    private final InvoiceReturnRepository invoiceReturnRepository;
    private final InvoiceReturnMapper invoiceReturnMapper;
    private final InvoiceRepository invoiceRepository;


    @Autowired
    public InvoiceReturnServiceImpl(InvoiceReturnRepository invoiceReturnRepository, InvoiceReturnMapper invoiceReturnMapper, InvoiceRepository invoiceRepository) {
        this.invoiceReturnRepository = invoiceReturnRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceReturnMapper = invoiceReturnMapper;
    }

    @Override
    public List<InvoiceReturnDTO> getAllInvoiceReturns() {
        List<InvoiceReturnModel> invoiceReturns = invoiceReturnRepository.findAll();
        return invoiceReturns.stream()
                .map(invoiceReturnMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceReturnDTO getInvoiceReturnById(Long id) {
        InvoiceReturnModel invoiceReturn = invoiceReturnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice return not found with id: " + id));
        return invoiceReturnMapper.toDTO(invoiceReturn);
    }

//    @Override
//    public InvoiceReturnDTO createInvoiceReturn(InvoiceReturnDTO invoiceReturnDTO) {
//        InvoiceReturnModel invoiceReturn = invoiceReturnMapper.toEntity(invoiceReturnDTO);
//        InvoiceReturnModel savedInvoiceReturn = invoiceReturnRepository.save(invoiceReturn);
//        return invoiceReturnMapper.toDTO(savedInvoiceReturn);
//    }

    @Override
    public InvoiceReturnDTO createInvoiceReturn(InvoiceReturnDTO invoiceReturnDTO) {
        if (invoiceReturnDTO.getInvoiceID() == null) {
            throw new IllegalArgumentException("Invoice ID must be provided");
        }

        // Fetch the invoice from the database
        InvoiceModel invoice = invoiceRepository.findById(invoiceReturnDTO.getInvoiceID())
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + invoiceReturnDTO.getInvoiceID()));

        // Create the InvoiceReturnModel entity and set the invoice
        InvoiceReturnModel invoiceReturn = new InvoiceReturnModel(
                invoice,
                invoiceReturnDTO.getReturnDate(),
                invoiceReturnDTO.getReturnReason(),
                invoiceReturnDTO.getRefundAmount()
                );

        // Save the invoice to the database
        InvoiceReturnModel savedInvoiceReturn = invoiceReturnRepository.save(invoiceReturn);
        return invoiceReturnMapper.toDTO(savedInvoiceReturn);
    }

    @Override
    public InvoiceReturnDTO updateInvoiceReturn(Long id, InvoiceReturnDTO invoiceReturnDTO) {
        InvoiceReturnModel existingInvoiceReturn = invoiceReturnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice return not found with id: " + id));
        if(invoiceReturnDTO.getReturnDate()!=null){
            existingInvoiceReturn.setReturnDate(invoiceReturnDTO.getReturnDate());
        }
        if(invoiceReturnDTO.getReturnReason()!=null){
            existingInvoiceReturn.setReturnReason(invoiceReturnDTO.getReturnReason());
        }
        if(invoiceReturnDTO.getRefundAmount()!=null){
            existingInvoiceReturn.setRefundAmount(invoiceReturnDTO.getRefundAmount());
        }

        // Update properties here
        InvoiceReturnModel updatedInvoiceReturn = invoiceReturnRepository.save(existingInvoiceReturn);
        return invoiceReturnMapper.toDTO(updatedInvoiceReturn);
    }

    @Override
    public void deleteInvoiceReturn(Long id) {
        if (!invoiceReturnRepository.existsById(id)) {
            throw new RuntimeException("Invoice return not found with id: " + id);
        }
        invoiceReturnRepository.deleteById(id);
    }
}
