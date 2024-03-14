package org.pgs.postp.service;

import org.pgs.postp.dto.VoucherDTO;

import java.util.List;

public interface VoucherService {
    List<VoucherDTO> getAllVouchers();

    VoucherDTO getVoucherById(Long id);

    VoucherDTO createVoucher(VoucherDTO voucherDTO);

    VoucherDTO updateVoucher(Long id, VoucherDTO voucherDTO);

    void deleteVoucher(Long id);
}
