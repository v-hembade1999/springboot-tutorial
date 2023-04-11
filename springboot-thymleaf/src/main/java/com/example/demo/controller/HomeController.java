package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoginData;

@Controller
public class HomeController 
{
	
	
	@GetMapping("/form")
	public String openform(Model model)
	{
		model.addAttribute("LoginData",new LoginData());
		return "form";
	}
	
	@PostMapping("/process")
	public String processform(@Valid @ModelAttribute("LoginData") LoginData data, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
			return "form";
		}
		return "sucess";
	}
	
	@GetMapping("/hello")
	public String about(Model m)
	{
		List<String> users = List.of("rock","sam","jack","hardy","leo");
		m.addAttribute("users",users);
		
		return "about";
	}
	
	@GetMapping("/condition")
	public String condition(Model m)
	{
		m.addAttribute("isactive",true);
		m.addAttribute("gender","f");
		return "condition";
	}
	
	
}
