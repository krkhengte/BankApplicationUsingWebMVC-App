package com.jfs.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.jfs.backend.entity.Account;

@Controller
public class ATM_Controller {
	
	
	
	@PostMapping("/atm")
	public String displayATM_Service(Model model) {
		
		model.addAttribute("account", "Welcome To ATM Service" );
		
		return "atm";
	}

}
