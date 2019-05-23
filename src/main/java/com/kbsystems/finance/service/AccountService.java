package com.kbsystems.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbsystems.finance.domain.Account;
import com.kbsystems.finance.repository.AccountRepository;

@Service
public class AccountService {
	private AccountRepository accountRepository;
	public AccountService(@Autowired AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Account create(Account account) {
		return this.accountRepository.save(account);
	}
}
