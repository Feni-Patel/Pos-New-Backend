package org.pgs.postp.mapper;

import org.pgs.postp.dto.VoucherDTO;
import org.pgs.postp.model.VoucherModel;
import org.springframework.stereotype.Component;

@Component
public class VoucherMapper {

    public VoucherDTO toDTO(VoucherModel voucherModel) {
        if (voucherModel == null) {
            return null;
        }
        VoucherDTO voucherDTO = new VoucherDTO();
        voucherDTO.setVoucherID(voucherModel.getVoucherID());
        voucherDTO.setVoucherType(voucherModel.getVoucherType());
        voucherDTO.setVoucherDuration(voucherModel.getVoucherDuration());
        voucherDTO.setVoucherCount(voucherModel.getVoucherCount());
        voucherDTO.setDiscountAmount(voucherModel.getDiscountAmount());
        return voucherDTO;
    }

    public VoucherModel toEntity(VoucherDTO voucherDTO) {
        if (voucherDTO == null) {
            return null;
        }
        VoucherModel voucherModel = new VoucherModel();
        voucherModel.setVoucherID(voucherDTO.getVoucherID());
        voucherModel.setVoucherType(voucherDTO.getVoucherType());
        voucherModel.setVoucherDuration(voucherDTO.getVoucherDuration());
        voucherModel.setVoucherCount(voucherDTO.getVoucherCount());
        voucherModel.setDiscountAmount(voucherDTO.getDiscountAmount());
        return voucherModel;
    }
}
