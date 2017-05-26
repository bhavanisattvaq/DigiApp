package com.sattvaq.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerOperations {
	@RequestMapping("/home.htm")
	public String showHomePage(){
		return "home";
	}
	
	@RequestMapping("/profile.htm")
	public String showProfilePage(Map<String,String> map){
		map.put("name", "bhavani sankar");
		map.put("age", "23");
		map.put("addrs", "hyderabad");
		return "view_profile";
	}
	
	@RequestMapping("/phone.htm")
	public String showPhoneNumbersPage(Map<String,String> map){
		map.put("phone", "8297534282");
		return "phone_numbers";
	}



}
