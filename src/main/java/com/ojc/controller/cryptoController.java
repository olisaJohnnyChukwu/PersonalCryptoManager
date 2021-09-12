package com.ojc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ojc.Service.ICryptoservice;

@Controller
public class cryptoController {
	
	@Autowired
	ICryptoservice cryptoService ;
	
	@GetMapping("/cryptos")
	public String listcryptos(Model model) {
		
		model.addAttribute("list", cryptoService.getAll());
		return "crypto";
		
	}
}
