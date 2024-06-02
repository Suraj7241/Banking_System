package com.Banking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Banking.Model.Account;
import com.Banking.Model.User;

public interface AccountRepository extends JpaRepository<Account,Long> {
	
	 List<Account> findByUser(User user);

}
