package org.pgs.postp.mapper;

import org.pgs.postp.dto.UserDTO;
import org.pgs.postp.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Convert UserModel to UserDTO
    public UserDTO toDTO(UserModel model) {
        UserDTO dto = new UserDTO();
        dto.setUserID(model.getUserID());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        // You might choose to map other properties here, depending on your requirements
        return dto;
    }

    // Convert UserDTO to UserModel
    public static UserModel toEntity(UserDTO dto) {
        UserModel model = new UserModel();
        model.setUserID(dto.getUserID());
        model.setUsername(dto.getUsername());
        model.setPassword(dto.getPassword());
        // You might choose to map other properties here, depending on your requirements
        return model;
    }
}
