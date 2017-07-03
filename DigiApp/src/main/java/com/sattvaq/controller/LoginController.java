package com.sattvaq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sattvaq.command.LoginForm;
import com.sattvaq.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired(required=true)
	private LoginService service;
	
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String showForm(Model model) {
		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginForm",loginForm);
		return "login";
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String  processForm(Model model,
			                                         @ModelAttribute("loginForm") LoginForm loginForm,
			                                        BindingResult errors,HttpServletRequest request){
		
		 
		
		HttpSession session=request.getSession();
		String useremail=request.getParameter("useremail");
		session.setAttribute("useremail", useremail);
       
		if (errors.hasErrors()) {
			return "login";
		}
		boolean userExists = service.checkLogin(loginForm.getUseremail(),loginForm.getPassword());
		if(userExists){
			model.addAttribute("loginForm", loginForm);
			return "loginsuccess";
		}else{
			errors.rejectValue("useremail","invaliduser");
			model.addAttribute("msg", "invalid username and password");
			return "login";
		}
	}//method
	/*@RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "login";
    }*/
	
	
		@RequestMapping(value="/logout.htm",method = RequestMethod.GET)
	    public String logout(HttpServletRequest request, Model map){
	        HttpSession httpSession = request.getSession();
	        httpSession.invalidate();
	       
	        return "redirect:/login.htm";
		}
}//class

