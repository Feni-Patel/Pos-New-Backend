package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.RoleDTO;
import org.pgs.postp.mapper.RoleMapper;
import org.pgs.postp.model.RoleModel;
import org.pgs.postp.repository.RoleRepository;
import org.pgs.postp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        List<RoleModel> roles = roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        RoleModel role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        return roleMapper.toDTO(role);
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        RoleModel role = roleMapper.toEntity(roleDTO);
        RoleModel savedRole = roleRepository.save(role);
        return roleMapper.toDTO(savedRole);
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        RoleModel existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        if (roleDTO.getRoleName() != null) {
            existingRole.setRoleName(roleDTO.getRoleName());
        }
        // Update properties here
        RoleModel updatedRole = roleRepository.save(existingRole);
        return roleMapper.toDTO(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
    }
}