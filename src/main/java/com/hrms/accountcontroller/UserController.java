package com.hrms.accountcontroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hrms.accountservice.UserService;
import com.hrms.entity.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        Optional<User> existing = userService.loginUser(user.getEmail(), user.getPassword());
        if (existing.isPresent()) {
            return "User already exists ❌";
        }
        userService.registerUser(user);
        return "Registration successful ✅";
    }

    // Login existing user
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        Optional<User> existingUser = userService.loginUser(user.getEmail(), user.getPassword());
        return existingUser.isPresent() ? "Login successful ✅" : "Invalid email or password ❌";
    }

  
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

   
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        boolean updated = userService.updateUser(id, updatedUser);
        return updated ? "User updated successfully ✅" : "User not found ❌";
    }

    
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? "User deleted successfully ✅" : "User not found ❌";
    }
}
