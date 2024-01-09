package com.jfs.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jfs.backend.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

	public List<Account> findByUsernameAndPassword(String uname, String pass);

	// public List<Account> findByUsername(String uname);

	public List<Account> findByAccountnumber(String accNum);

}
