package org.pgs.postp.service;

import org.pgs.postp.dto.TaxDTO;

import java.util.List;

public interface TaxService {
    List<TaxDTO> getAllTaxes();

    TaxDTO getTaxById(Long id);

    TaxDTO createTax(TaxDTO taxDTO);

    TaxDTO updateTax(Long id, TaxDTO taxDTO);

    void deleteTax(Long id);
}
