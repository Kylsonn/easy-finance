package com.kbsystems.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kbsystems.finance.domain.Account;
import com.kbsystems.finance.repository.AccountRepository;
import com.kbsystems.finance.service.exception.ResourceAlreadyExistsException;

@Service
public class AccountService {
	private AccountRepository accountRepository;
	public AccountService(@Autowired AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Account create(Account account) {
		if(this.accountRepository.findByUserAndName(account.getUser(), account.getName()).isPresent()) {
			throw new ResourceAlreadyExistsException(Account.class.getSimpleName());
		}
		return this.accountRepository.save(account);
	}
	
	public Account update(Account account) {
		return this.accountRepository.save(account);
	}
}
