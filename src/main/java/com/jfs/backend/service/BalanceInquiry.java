package com.jfs.backend.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.FactoryBeanRegistrySupport;
import org.springframework.stereotype.Service;

import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

@Service
public class BalanceInquiry {

	String accountNumber = "";
	public String accountNumber2 = "";
	public Float accountBalance;
	public String holderName = "";
	public boolean balanceInquiryStatus = false;

	@Autowired
	private AccountRepository accountRep;

	public void BalanceInquiry(String accountNumber) {

		Account fba = (Account) accountRep.findByAccountnumber(accountNumber);

		holderName = fba.getHoldername();
		accountBalance = fba.getAccountbalance();
		accountNumber2 = fba.getAccountnumber();

		if (fba.equals(accountNumber2)) {
			System.out.println("1");
			balanceInquiryStatus = true;

		} else {
			System.out.println("2");
			balanceInquiryStatus = false;
		}

	}

}
