package com.jfs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jfs.backend.service.LoginAccount;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("home", "Welcome To State Bank Of India");
		return "home";
	}

}
