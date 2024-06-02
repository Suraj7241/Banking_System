package com.Banking.Service;

import java.util.List;

import com.Banking.Model.Account;
import com.Banking.Model.User;

public interface AccountService {
	
	//new account
	Account save(Account account);
	
	//get by id
    Account findById(Long id);
    
    //get all account
    List<Account> findByUser(User user);
    
    //delete account
    void deleteById(Long id);

}
