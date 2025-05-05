package com.hrms.accountservice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.accountrepo.UserRepository;
import com.hrms.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    // ✅ Get all users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Update user
    @Override
    public boolean updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setContact(updatedUser.getContact());
            user.setGender(updatedUser.getGender());
            user.setPan(updatedUser.getPan());
            user.setPassword(updatedUser.getPassword());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    // ✅ Delete user
    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
