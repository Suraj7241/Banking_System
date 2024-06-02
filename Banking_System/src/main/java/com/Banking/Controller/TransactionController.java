package com.Banking.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Banking.Model.Account;
import com.Banking.Model.Transaction;
import com.Banking.Model.User;
import com.Banking.Service.AccountService;
import com.Banking.Service.TransactionService;
import com.Banking.Service.UserService;


@Controller
@RequestMapping("/bank/transactions")
public class TransactionController {
	
	private final TransactionService transactionService;
	  private final AccountService accountService;
	    private final UserService userService;

	    @Autowired
	    public TransactionController(TransactionService transactionService, AccountService accountService, UserService userService) {
	        this.transactionService = transactionService;
	        this.accountService = accountService;
	        this.userService = userService;
	    }
	    

	    @GetMapping
	    public String listTransactions(@RequestParam Long accountId, Model model, Principal principal) {
	        User user = userService.findByUsername(principal.getName());
	        Account account = accountService.findById(accountId);
	        if (account == null || !account.getUser().getId().equals(user.getId())) {
	            return "error";
	        }
	        List<Transaction> transactions = transactionService.findByAccount(account);
	        model.addAttribute("transactions", transactions);
	        model.addAttribute("account", account);
	        return "transactions";
	    }

	    @GetMapping("/new")
	    public String showNewTransactionForm(@RequestParam Long accountId, Model model) {
	        Account account = accountService.findById(accountId);
	        if (account == null) {
	            return "error";
	        }
	        model.addAttribute("account", account);
	        model.addAttribute("transaction", new Transaction());
	        return "new-transaction";
	    }

	    @PostMapping("/credit")
	    public String createCreditTransaction(@RequestParam Long accountId, @RequestParam double amount, @RequestParam String description, Model model) {
	        Account account = accountService.findById(accountId);
	        if (account == null) {
	            return "error";
	        }
	        transactionService.credit(account, amount, description);
	        return "redirect:/bank/transactions?accountId=" + accountId;
	    }

	    @PostMapping("/debit")
	    public String createDebitTransaction(@RequestParam Long accountId, @RequestParam double amount, @RequestParam String description, Model model) {
	        Account account = accountService.findById(accountId);
	        if (account == null) {
	            return "error";
	        }
	        Transaction transaction = transactionService.debit(account, amount, description);
	        if (transaction == null) {
	            model.addAttribute("error", "Insufficient funds");
	            model.addAttribute("account", account);
	            return "new-transaction";
	        }
	        return "redirect:/bank/transactions?accountId=" + accountId;
	    }

	    @GetMapping("/{id}/delete")
	    public String deleteTransaction(@PathVariable Long id, @RequestParam Long accountId) {
	        transactionService.deleteById(id);
	        return "redirect:/bank/transactions?accountId=" + accountId;
	    }

}
