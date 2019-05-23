package com.kbsystems.finance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kbsystems.finance.domain.Account;
import com.kbsystems.finance.domain.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	public Optional<Account> findByUserAndName(User user, String name); 
}
