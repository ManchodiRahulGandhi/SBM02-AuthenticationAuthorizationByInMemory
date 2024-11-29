package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//RBAC using in memory
@RestController
public class BankOperationController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/home")
	public String showHome1() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	
	@GetMapping("/show_balance")
	public String checkBalance() {
		return "show_balance";
	}
	
	@GetMapping("/loanApprove")
	public String approveLoan() {
		return "loan";
	}
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}
}
