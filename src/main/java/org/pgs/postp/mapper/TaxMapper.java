package org.pgs.postp.mapper;

import org.pgs.postp.dto.TaxDTO;
import org.pgs.postp.model.TaxModel;
import org.springframework.stereotype.Component;

@Component
public class TaxMapper {

    // Convert TaxModel to TaxDTO
    public TaxDTO toDTO(TaxModel model) {
        TaxDTO dto = new TaxDTO();
        dto.setTaxID(model.getTaxID());
        dto.setTaxName(model.getTaxName());
        dto.setTaxRate(model.getTaxRate());
        return dto;
    }

    // Convert TaxDTO to TaxModel
    public static TaxModel toEntity(TaxDTO dto) {
        TaxModel model = new TaxModel();
        model.setTaxID(dto.getTaxID());
        model.setTaxName(dto.getTaxName());
        model.setTaxRate(dto.getTaxRate());
        return model;
    }
}
