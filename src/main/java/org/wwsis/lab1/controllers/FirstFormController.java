package org.wwsis.lab1.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wwsis.lab1.model.Student;



@Controller
public class FirstFormController {

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	Student student = new Student();
	
	
	@RequestMapping("/firstForm")
	public String getForm(Model model, Student student) {

		model.addAttribute("dateTime", "Aktualna data i godzina: " + dateFormat.format(date));
		model.addAttribute("formName", "Moj formularz:");
		model.addAttribute("student", student);

		return "firstForm";
	}
	
	@RequestMapping("/defaultStudent")
	public String defaultStudent(Model model, final RedirectAttributes redirectAttributes){
		Student student = new Student();
		student.setAge(19);
		student.setEmail("student@student.com");
		student.setFirstName("Alojzy");
		student.setLastName("Kleks");
		student.setAddress("Ul. Sezamkowa 72, 54-334 Pasikurowice");
		redirectAttributes.addFlashAttribute(student);
		return "redirect:firstForm";
	}

	@PostMapping("/firstForm")
	public String postForm(Model model, Student student, BindingResult result) {
		
		if(student.getAge() < 0) {

			model.addAttribute("formName", "Moj formularz:");
			model.addAttribute("dateTime", "Aktualna data i godzina: " + dateFormat.format(date));
			model.addAttribute("errorMessage", "Niepoprawna wartosc w polu wiek!");
			return "firstForm";
		}
		
		if(result.hasErrors()){
			model.addAttribute("formName", "Moj formularz:");
			model.addAttribute("dateTime", "Aktualna data i godzina: " + dateFormat.format(date));
			model.addAttribute("errorMessage", "Podana data niepoprawna");
		}
		
		
		model.addAttribute("studentFirstName", student.getFirstName());
		model.addAttribute("studentLastName", student.getLastName());
		model.addAttribute("studentAge", student.getAge());
		model.addAttribute("studentEmail", student.getEmail());
		model.addAttribute("studentAddress", student.getAddress());
		model.addAttribute("studentDataUrodzenia",student.getDataUrodzenia());
		return "secondForm";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new
		CustomDateEditor(dateFormat, true));
	}
}