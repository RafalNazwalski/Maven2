package org.wwsis.lab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wwsis.lab1.model.Address;

@Controller
public class AddressController {

	@RequestMapping("/addressForm")
	public String getForm(Model model){
		
		model.addAttribute("formName", "Formularz adresu:");
		model.addAttribute("address", new Address());	
		return "addressForm";
	}
	
	@PostMapping("/addressForm")
	public String postForm(Model model, Address address){
		
		model.addAttribute("formName", "Formularz adresu:");
		model.addAttribute("addressMiejscowosc", address.getMiejscowosc());
		model.addAttribute("addressUlica", address.getUlica());
		model.addAttribute("addressNumerDomu", address.getNumerDomu());
		return "addressDisplay";
	}
	
		
}
