package com.qa.model;

import com.qa.domain.Account;

public interface AccountRepo {

	public Account addAccount(Account account);

	public Account getAccount(Long id);

	public void removeAccount(Long id);

	public Account updateAccount(Long id, Account account);

}
