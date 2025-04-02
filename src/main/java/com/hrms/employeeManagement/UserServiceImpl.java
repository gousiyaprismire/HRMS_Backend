package com.hrms.employeeManagement;
 
import java.util.List;

import java.util.Random;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
 
@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;

    }
 
    @Override

    public User registerUser(User user) {

        user.setEmployeeCode(generateUniqueEmployeeCode());

        return userRepository.save(user);

    }
 
    private String generateUniqueEmployeeCode() {

        String prefix = "PSS";

        Random random = new Random();

        String employeeCode;

        do {

            int number = 1000 + random.nextInt(9000);

            employeeCode = prefix + number;

        } while (userRepository.existsByEmployeeCode(employeeCode));

        return employeeCode;

    }
 
    @Override

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }
 
    @Override

    public User getUserById(Long id) {

        return userRepository.findById(id)

            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

    }
 
    @Override

    public User updateUser(Long id, User user) {

        User existingUser = userRepository.findById(id)

            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        existingUser.setFirstName(user.getFirstName());

        existingUser.setLastName(user.getLastName());

        existingUser.setEmail(user.getEmail());

        existingUser.setPhoneNumber(user.getPhoneNumber());

        existingUser.setDob(user.getDob());

        existingUser.setGender(user.getGender());

        existingUser.setPan(user.getPan());

        existingUser.setPreviousCompany(user.getPreviousCompany());

        existingUser.setCtc(user.getCtc());

        existingUser.setUserType(user.getUserType());

        return userRepository.save(existingUser);

    }
 
    @Override

    public void deleteUser(Long id) {

        User user = userRepository.findById(id)

            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        userRepository.delete(user);

    }

}
 