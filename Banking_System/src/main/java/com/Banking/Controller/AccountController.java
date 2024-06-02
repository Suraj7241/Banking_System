package com.Banking.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Banking.Model.Account;
import com.Banking.Model.User;
import com.Banking.Service.AccountService;
import com.Banking.Service.UserService;

@Controller
@RequestMapping("/bank/accounts")
public class AccountController {
	
	private final AccountService accountService;
	private final UserService userService;
	
	@Autowired
	public AccountController(AccountService accountService, UserService userService) {
		this.accountService = accountService;
		this.userService = userService;
	}
	
	@GetMapping
	public String listAccounts(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		List<Account> accounts = accountService.findByUser(user);
		model.addAttribute("accounts",accounts);
		return "accounts";
	}
	
	@GetMapping("/new")
	public String showNewAccountNew(Model model) {
		model.addAttribute("account", new Account());
		return "new-account";
	}
	
	@PostMapping
	public String createAccount(Account account,Principal principal) {
		User user =userService.findByUsername(principal.getName());
		account.setUser(user);
		accountService.save(account);
		return "redirect:/bank/login";
	}
	
	@GetMapping("/bank/login")
	public String showLoginForm() {
		return "login";
	}
	

}
