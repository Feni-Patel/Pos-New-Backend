package org.pgs.postp.service.Impl;


import org.pgs.postp.dto.VoucherDTO;
import org.pgs.postp.mapper.VoucherMapper;
import org.pgs.postp.repository.VoucherRepository;
import org.pgs.postp.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;
    private final VoucherMapper voucherMapper;

    @Autowired
    public VoucherServiceImpl(VoucherRepository voucherRepository, VoucherMapper voucherMapper) {
        this.voucherRepository = voucherRepository;
        this.voucherMapper = voucherMapper;
    }

    @Override
    public List<VoucherDTO> getAllVouchers() {
        return voucherRepository.findAll().stream()
                .map(voucherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VoucherDTO getVoucherById(Long id) {
        return voucherRepository.findById(id)
                .map(voucherMapper::toDTO)
                .orElse(null);
    }

    @Override
    public VoucherDTO createVoucher(VoucherDTO voucherDTO) {
        return voucherMapper.toDTO(voucherRepository.save(voucherMapper.toEntity(voucherDTO)));
    }

    @Override
    public VoucherDTO updateVoucher(Long id, VoucherDTO voucherDTO) {
        if (voucherRepository.existsById(id)) {
            voucherDTO.setVoucherID(id);
            return voucherMapper.toDTO(voucherRepository.save(voucherMapper.toEntity(voucherDTO)));
        }
        return null;
    }

    @Override
    public void deleteVoucher(Long id) {
        voucherRepository.deleteById(id);
    }
}
