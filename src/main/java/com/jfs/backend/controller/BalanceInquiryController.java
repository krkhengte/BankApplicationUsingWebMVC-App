package com.jfs.backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.jfs.backend.entity.Account;
import com.jfs.backend.service.BalanceInquiry;

import jakarta.validation.Valid;

@Controller
public class BalanceInquiryController {

	@Autowired
	private BalanceInquiry balanceInquiry;
	
	Account account= new Account();
	@PostMapping("/balanceInq")
	public String balanceInquiry(Account account,Model model) {
		
		model.addAttribute("account", account);
		
		return "balanceInquiry";
		
	}
	
	@PostMapping("/balanceInquiryDone")
	public String getBalanceInquiryData(@Valid Account account,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			return "balanceInquiry";
		}
		
		String accNum=account.getAccountnumber();
		System.out.println(accNum);
		balanceInquiry.BalanceInquiry(accNum);
		
		if(balanceInquiry.balanceInquiryStatus==true) {
			List<Object> asList = Arrays.asList(balanceInquiry.holderName,balanceInquiry.accountBalance,balanceInquiry.accountNumber2);
			model.addAttribute("balanceInquiry",asList);
			return "balanceInquirySuccess";
		}else {
			
			return "balanceInquiry";
		}
		
		
	}
	
}
