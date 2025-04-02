package com.hrms.Login;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountCreationController {
 
    @Autowired
    private AccountCreationService accountCreationService;
 
    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody AccountCreationEntity accountCreationEntity) {
        accountCreationService.createAccount(accountCreationEntity);
        return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
    }
 
    @GetMapping("/all")
    public ResponseEntity<List<AccountCreationEntity>> getAllAccounts() {
        List<AccountCreationEntity> accounts = accountCreationService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
 
    
    @GetMapping("/get")
    public Optional<AccountCreationEntity> getAccountByEmail(@RequestParam String email) {
        return accountCreationService.getAccountByEmail(email);
    }
    @PutMapping("/update")
    public String updateAccountByEmail(@RequestParam String email, @RequestBody AccountCreationEntity accountDetails) {
        return accountCreationService.updateAccountByEmail(email, accountDetails);
    }
    @GetMapping("/email")
    public ResponseEntity<List<AccountCreationEntity>> getAccountsByEmailAndPassword(
            @RequestParam String email, @RequestParam String password) {
        System.out.println("Received request with email: " + email + ", password: " + password);
 
        List<AccountCreationEntity> accounts = accountCreationService.getAccountsByEmailAndPassword(email, password);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
 
    @PostMapping("/login")
    public ResponseEntity<AccountCreationEntity> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
 
        Optional<AccountCreationEntity> account = accountCreationService.login(email, password);
        return account.map(a -> ResponseEntity.ok(a))
                .orElse(null);
    }
}