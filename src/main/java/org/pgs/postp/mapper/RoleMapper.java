package org.pgs.postp.mapper;

import org.pgs.postp.dto.RoleDTO;
import org.pgs.postp.model.RoleModel;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    // Convert RoleModel to RoleDTO
    public RoleDTO toDTO(RoleModel model) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleID(model.getRoleID());
        dto.setRoleName(model.getRoleName());
        // You can map other fields here if needed
        return dto;
    }

    // Convert RoleDTO to RoleModel
    public RoleModel toEntity(RoleDTO dto) {
        RoleModel model = new RoleModel();
        model.setRoleID(dto.getRoleID());
        model.setRoleName(dto.getRoleName());
        // You can map other fields here if needed
        return model;
    }
}
