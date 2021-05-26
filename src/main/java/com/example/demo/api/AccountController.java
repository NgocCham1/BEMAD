package com.example.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.data.AccountRepository;
import com.example.demo.model.Account;

@RestController
@RequestMapping(path = "/account", produces = "application/json")
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;
	
//	@Autowired
//	EntityLinks entityLinks;

	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@GetMapping
	public Iterable<Account> getAllAccount(){
		return accountRepository.findAll();
	}
	
	@GetMapping("/{ID}")
	public Account accountById(@PathVariable("ID") int ID) {
		Optional<Account> option = accountRepository.findById(ID);
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	
	@GetMapping("/email/{email}")
	public Account accountByEmail(@PathVariable("email") String email) {
		return accountRepository.getAccountByEmail(email);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Account postAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
}
