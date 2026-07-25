package com.service;

import com.model.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByUsername(String username);

    void deleteUser(Long id);

    // Thêm dòng này
    User login(String username, String password);
}