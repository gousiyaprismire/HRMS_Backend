package com.hrms.Login;

import java.util.List;
import java.util.Optional;

 
public interface AccountCreationService {
    void createAccount(AccountCreationEntity accountCreationEntity);
 
    List<AccountCreationEntity> getAllAccounts();
 
    List<AccountCreationEntity> getAccountsByEmailAndPassword(String email, String password);
 
    Optional<AccountCreationEntity> login(String email, String password);
 
	Optional<AccountCreationEntity> getAccountByEmail(String email);
 
	String updateAccountByEmail(String email, AccountCreationEntity accountDetails);
}