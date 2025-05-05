package com.hrms.accountservice;



import java.util.List;
import java.util.Optional;

import com.hrms.entity.User;

public interface UserService {
    User registerUser(User user);
    Optional<User> loginUser(String email, String password);

    // New methods
    List<User> getAllUsers();
    boolean updateUser(Long id, User user);
    boolean deleteUser(Long id);
}
