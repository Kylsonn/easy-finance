package com.kbsystems.finance.builder;

import com.kbsystems.finance.domain.Account;
import com.kbsystems.finance.domain.User;

public class AccountBuilder {
	private Account account;

	public AccountBuilder() {
		account = new Account();
	}

	public AccountBuilder setComment(String comment) {
		this.account.setComment(comment);
		return this;
	}

	public AccountBuilder setName(String name) {
		this.account.setName(name);
		return this;

	}

	public AccountBuilder setUser(User user) {
		this.account.setUser(user);
		return this;
	}

	public AccountBuilder setId(Long id) {
		account.setId(id);
		return this;
	}

	public Account toAccount() {
		return account;
	}
}
