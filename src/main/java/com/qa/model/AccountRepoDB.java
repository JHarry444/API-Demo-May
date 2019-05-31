package com.qa.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.domain.Account;
@Transactional(TxType.SUPPORTS)
public class AccountRepoDB implements AccountRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(TxType.REQUIRED)
	public Account addAccount(Account account) {
		this.em.persist(account);
		return this.getAccount(account.getId());
	}

	@Override
	public Account getAccount(Long id) {
		return this.em.find(Account.class, id);
	}

	@Override
	public void removeAccount(Long id) {
		this.em.remove(this.em.find(Account.class, id));

	}

	@Override
	public Account updateAccount(Long id, Account account) {
		// TODO Auto-generated method stub
		return null;
	}

}
