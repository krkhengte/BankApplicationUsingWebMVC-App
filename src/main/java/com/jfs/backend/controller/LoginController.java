package com.jfs.backend.controller;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;
import com.jfs.backend.service.LoginAccount;

import jakarta.validation.Valid;

@Controller

public class LoginController {

	@Autowired
	LoginAccount loginAccount;
	Account account = new Account();

	@PostMapping("/login")
	public String getLoginData(Account account,Model model) {

		model.addAttribute("account", account);

		return "login";

	}

	@PostMapping("/loginSuccess")
	public String getLogRes(@Valid Account account, BindingResult result, Model model) {
		System.out.println(account);
		System.out.println(result);
		if (result.hasErrors()) {
			return "login";
		}
		
		System.out.println(account);

		String uname = account.getUsername();
		String pass = account.getPassword();
		
		System.out.println(uname);
		System.out.println(pass);
		
		loginAccount.loginAcc(uname, pass);

		if (loginAccount.loginSuccess == true) {

			model.addAttribute("MSG", "Login Successfull..");
			System.out.println("1");
			return "loginSuccess";

		} else {
			model.addAttribute("failed", "Login Failed....");
			System.out.println("2");
			return "login";

		}
	}

}
