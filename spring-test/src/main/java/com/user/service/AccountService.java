package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: doudou
 * @since: 2022-08-11
 */
@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	@Transactional
	public void save() {
		accountDao.save();
		String str = null;
		str.length();
	}
}
