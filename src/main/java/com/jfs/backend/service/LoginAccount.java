package com.jfs.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jfs.backend.controller.LoginController;
import com.jfs.backend.entity.Account;
//import com.jfs.backend.FirstBankApplicationSbiApplication;
//import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

import lombok.Data;

@Service
@Data
public class LoginAccount {

	String userName = "";
	String password = "";

	public boolean loginSuccess = false;

	@Autowired
	private AccountRepository accountRep;

	LoginController logCont = new LoginController();
	Account acc = new Account();

	public void loginAcc(String userName, String pass) {

		List<Account> fbup = accountRep.findByUsernameAndPassword(userName, pass);

		System.out.println(fbup);
		
		if (fbup.isEmpty() == false) {
			System.out.println("Login Success...");
			loginSuccess = true;

		} else {
			System.out.println("Login Failed...");
			loginSuccess = false;
		}

	}

}
