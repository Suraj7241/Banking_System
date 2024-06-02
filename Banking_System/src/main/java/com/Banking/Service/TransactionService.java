package com.Banking.Service;

import java.util.List;

import com.Banking.Model.Account;
import com.Banking.Model.Transaction;

public interface TransactionService {

	//save transaction
	Transaction save(Transaction transaction);
	
   //find transaction by id
	Transaction findById(Long id);
	
	//find by as
    List<Transaction> findByAccount(Account account);
    
    //delete by id
    void deleteById(Long id);

    //credit transaction
    Transaction credit(Account account, double amount, String description);
   
    //debit transaction
    Transaction debit(Account account, double amount, String description);
}
