package org.pgs.postp.service.Impl;

import org.pgs.postp.dto.UserDTO;
import org.pgs.postp.mapper.UserMapper;
import org.pgs.postp.model.RoleModel;
import org.pgs.postp.model.UserModel;
import org.pgs.postp.repository.RoleRepository;
import org.pgs.postp.repository.UserRepository;
import org.pgs.postp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

//    @Override
//    public UserDTO createUser(UserDTO userDTO) {
//        UserModel user = userMapper.toEntity(userDTO);
//        UserModel savedUser = userRepository.save(user);
//        return userMapper.toDTO(savedUser);
//    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO.getRoleId() == null) {
            throw new IllegalArgumentException("Role ID must be provided");
        }

        // Fetch the role from the database
        RoleModel role = roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + userDTO.getRoleId()));

        // Create the UserModel entity and set the role
        UserModel user = new UserModel(
                userDTO.getUsername(),
                userDTO.getPassword(),
                role);

        // Save the user to the database
        UserModel savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }



    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        UserModel existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setPassword(userDTO.getPassword());
        // Update other properties as needed

        UserModel updatedUser = userRepository.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
