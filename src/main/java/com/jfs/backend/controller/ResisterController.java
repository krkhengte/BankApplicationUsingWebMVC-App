package com.jfs.backend.controller;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.jfs.backend.entity.Account;
import com.jfs.backend.service.RegisterNewAccount;

import jakarta.servlet.Registration;
import jakarta.validation.Valid;

@Controller
public class ResisterController {

	@Autowired
	private RegisterNewAccount createNewAccount;

	Account account = new Account();

	@PostMapping("/register")
	public String setRegisterInfor(Account account, Model model) {

		model.addAttribute("account", account);

		return "register";

	}

	@PostMapping("/registerSuccess")
	public String getRegisterInfo(@Valid Account account,BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "register";
		}
		
		createNewAccount.createNewAcc(account);

		if (createNewAccount.registrationSuccess == true) {

			model.addAttribute("MSG", "Registration Successfully Done.");
			
			return "registerSuccess";
		} else {
			return "register";
		}
	}

}
