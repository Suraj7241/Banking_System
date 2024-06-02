package com.Banking.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Banking.Model.Account;
import com.Banking.Model.Transaction;
import com.Banking.Repository.TransactionRepository;
import com.Banking.Service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository transactionRepository ;
	

	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}

	@Override
	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction findById(Long id) {
    Optional <Transaction> tranactionOptional = transactionRepository.findById(id);
		return tranactionOptional.orElse(null);
	}

	@Override
	public List<Transaction> findByAccount(Account account) {
		return transactionRepository.findByAccount(account);
	}

	@Override
	public void deleteById(Long id) {
		transactionRepository.deleteById(id);
		
	}

	@Override
	public Transaction credit(Account account, double amount, String description) {
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setAmount(amount);
		transaction.setDescription(description);
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction debit(Account account, double amount, String description) {
		double newBalance =account.getBalance()-amount;
		if(newBalance < 0) {
			return null;
		}
		account.setBalance(newBalance);
		Transaction transaction=new Transaction();
		transaction.setAccount(account);
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setAmount(-amount); //for debit amount
		transaction.setDescription(description);
		return transactionRepository.save(transaction);
	}

	

}
