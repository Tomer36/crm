package com.crmproject.crm.service;

import com.crmproject.crm.dto.UserDTO;
import com.crmproject.crm.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(UserDTO userDTO);
    User updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
