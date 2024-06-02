package com.Banking.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.*;
import com.Banking.Model.Account;
import com.Banking.Model.User;
import com.Banking.Repository.AccountRepository;
import com.Banking.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	  private final AccountRepository accountRepository ;
	  
	  
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account findById(Long id) {
		Optional<Account> accountOptional =accountRepository.findById(id);
		return accountOptional.orElse(null);
	}

	@Override
	public List<Account> findByUser(User user) {
		return accountRepository.findByUser(user);
	}

	@Override
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	   

		

		
	}
	