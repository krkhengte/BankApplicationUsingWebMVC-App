package com.jfs.backend.service;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

@Service
public class RegisterNewAccount {

	
	@Autowired
	private AccountRepository accRep;

	public boolean registrationSuccess = false;

	public void createNewAcc(Account account) {

		String accNum = "";
		Random rnd = new Random();
		String accNum1 = "";

		Stack st = new Stack();
		int k = 0;
		for (int i = 0; i < 5; i++) {

			st.add(k = rnd.nextInt(10));

		}
		Enumeration e = st.elements();

		while (e.hasMoreElements()) {
			accNum1 = String.valueOf(e.nextElement());
			// System.out.print(accNum1);
			accNum = accNum.concat(accNum1);
		}

		account.setAccountnumber(accNum);
		account.setHoldername(account.getHoldername());
		account.setAccountbalance(account.getAccountbalance());
		account.setUsername(account.getUsername());
		account.setPassword(account.getPassword());
		account.setHolderemailid(account.getHolderemailid());
		account.setHoldergender(account.getHoldergender());
		account.setHoldermobile(account.getHoldermobile());
	
		accRep.save(account);

		List<Account> fbup = accRep.findByUsernameAndPassword(account.getUsername(), account.getPassword());

		if (fbup.isEmpty()==false) {

			registrationSuccess = true;
			System.out.println("Registration Successfull...");

		} else {
			registrationSuccess = false;
		}

	}
}
