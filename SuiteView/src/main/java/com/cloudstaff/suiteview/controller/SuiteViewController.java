package com.cloudstaff.suiteview.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudstaff.suiteview.forms.model.LogInForm;
import com.cloudstaff.suiteview.service.UserService;

@Controller
public class SuiteViewController {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("logInForm", new LogInForm());
        return "login";
	}
	 @PostMapping("/dologin")
	public String doLogin(@ModelAttribute LogInForm loginForm,HttpServletResponse response) {
		if(userService.verifyLogin(loginForm.getUsername(), loginForm.getPassword())!=null){
			System.out.println("Success");
		}else{
			System.out.println("FAILED");
		}
		return "admin";
	}
}
