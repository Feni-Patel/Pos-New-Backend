package org.pgs.postp.mapper;

import org.pgs.postp.dto.VoucherDTO;
import org.pgs.postp.model.VoucherModel;
import org.springframework.stereotype.Component;

@Component
public class VoucherMapper {

    public VoucherDTO toDTO(VoucherModel model) {
        if (model == null) {
            return null;
        }

        VoucherDTO dto = new VoucherDTO();
        dto.setVoucherID(model.getVoucherID());
        dto.setVoucherCode(model.getVoucherCode());
        dto.setDiscountAmount(model.getDiscountAmount());
        dto.setValidForNumberOfCustomers(model.getValidForNumberOfCustomers());
        dto.setValidForNumberOfDays(model.getValidForNumberOfDays());
//        dto.setValidUntil(model.getValidUntil());

        return dto;
    }

    public static VoucherModel toModel(VoucherDTO dto) {
        if (dto == null) {
            return null;
        }

        VoucherModel model = new VoucherModel();
        model.setVoucherID(dto.getVoucherID());
        model.setVoucherCode(dto.getVoucherCode());
        model.setDiscountAmount(dto.getDiscountAmount());
        model.setValidForNumberOfCustomers(dto.getValidForNumberOfCustomers());
        model.setValidForNumberOfDays(dto.getValidForNumberOfDays());
//        model.setValidUntil(dto.getValidUntil());

        return model;
    }

    public VoucherModel toEntity(VoucherDTO voucherDTO) {
        if (voucherDTO == null) {
            return null;
        }
        VoucherModel voucherModel = new VoucherModel();
        voucherModel.setVoucherID(voucherDTO.getVoucherID());
        voucherModel.setVoucherCode(voucherDTO.getVoucherCode());
        voucherModel.setDiscountAmount(voucherDTO.getDiscountAmount());
        voucherModel.setValidForNumberOfCustomers(voucherDTO.getValidForNumberOfCustomers());
        voucherModel.setValidForNumberOfDays(voucherDTO.getValidForNumberOfDays());
//        voucherModel.setValidUntil(voucherDTO.getValidUntil());
        return voucherModel;
    }


}
