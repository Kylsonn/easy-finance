package com.kbsystems.finance.service;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kbsystems.finance.builder.AccountBuilder;
import com.kbsystems.finance.builder.UserBuilder;
import com.kbsystems.finance.domain.Account;
import com.kbsystems.finance.domain.User;
import com.kbsystems.finance.repository.AccountRepository;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountServiceTest {
	@Mock
	private AccountRepository accountRepository;

	private AccountService accountService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.accountService = new AccountService(this.accountRepository);
	}

	@Test
	public void create_new_account() {
		User user = new UserBuilder().setId(1L).setUsername("Kylsonn").setPassword("abcd1234").toUser();
		Account account = new AccountBuilder().setComment("Conta principal").setUser(user).setName("Conta caixa")
				.toAccount();
		Account accountSaved = new AccountBuilder().setComment("Conta principal").setUser(user).setName("Conta caixa")
				.setId(1L).toAccount();
		when(accountRepository.save(account)).thenReturn(accountSaved);
		Account accountReturned = this.accountService.create(account);
		assertThat(accountSaved.getId(), equalTo(accountReturned.getId()));
	}
}
