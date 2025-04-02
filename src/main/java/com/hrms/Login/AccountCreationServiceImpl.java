package com.hrms.Login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

 
@Service
public class AccountCreationServiceImpl implements AccountCreationService {
 
	@Autowired
	private AccountCreationRepository accountCreationRepository;
 
	@Override
	public void createAccount(AccountCreationEntity accountCreationEntity) {
		// Implement the logic to create an account
		accountCreationRepository.save(accountCreationEntity);
	}
 
	@Override
	public List<AccountCreationEntity> getAllAccounts() {
		// Implement the logic to retrieve all accounts
		return accountCreationRepository.findAll();
	}
 
	@Override
	public Optional<AccountCreationEntity> login(String email, String password) {
		// Find the account by email
		Optional<AccountCreationEntity> optionalAccount = accountCreationRepository.findByEmail(email);
 
		if (optionalAccount.isPresent()) {
			AccountCreationEntity account = optionalAccount.get();
 
			// Check if the provided password matches the stored password
			if (account.getPassword().equals(password)) {
				// Passwords match, return the account
				return Optional.of(account);
			}
		}
 
		// Either the account with the provided email doesn't exist or the password is
		// incorrect
		return Optional.empty();
	}
 
	@Override
	public List<AccountCreationEntity> getAccountsByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Optional<AccountCreationEntity> getAccountByEmail(String email) {
		// Find the account by email
		Optional<AccountCreationEntity> optionalAccount = accountCreationRepository.findByEmail(email);
 
		if (optionalAccount.isPresent()) {
			AccountCreationEntity account = optionalAccount.get();
 
			return Optional.of(account);
 
		}
 
		// Either the account with the provided email doesn't exist or the password is
		// incorrect
		return Optional.empty();
	}
 
	
	@Override
    public String updateAccountByEmail(String email, AccountCreationEntity accountDetails) {
        Optional<AccountCreationEntity> optionalAccount = accountCreationRepository.findByEmail(email);
 
        if (optionalAccount.isPresent()) {
            // Update account details
            AccountCreationEntity account = optionalAccount.get();
            // Assuming AccountCreationEntity has setters for its fields
            account.setPassword(accountDetails.getPassword());
            // Update other fields as needed
            accountCreationRepository.save(account);
            return "Account updated successfully";
        } else {
            return "Account not found for the provided email";
        }
    }
}