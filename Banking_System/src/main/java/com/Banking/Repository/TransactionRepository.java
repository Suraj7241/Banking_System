package com.Banking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Banking.Model.Account;
import com.Banking.Model.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction,Long>{

	List<Transaction> findByAccount(Account account);
}
