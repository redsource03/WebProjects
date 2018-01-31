package com.cloudstaff.suiteview.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudstaff.suiteview.dynamodb.model.UserItem;
import com.cloudstaff.suiteview.forms.model.LogInForm;
import com.cloudstaff.suiteview.service.UserService;
import com.cloudstaff.suiteview.utils.SessionUtil;

@Controller
public class SuiteViewController {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Model model,HttpServletRequest request, HttpServletResponse response) {
		if(SessionUtil.isAlreadyLogin(request)==null){
			model.addAttribute("logInForm", new LogInForm());
	        return "login";
		}else{
			UserItem item = userService.getUserByKey(SessionUtil.isAlreadyLogin(request));
			if (item!=null){
				if(item.getAdmin().equalsIgnoreCase("y")){
					return "admin";
				}else{
					return "admin";/// need to change to normal user page				
				}
			}else{
				return "login";
			}
			
		}
		
	}
	 @PostMapping("/dologin")
	public String doLogin(@ModelAttribute LogInForm loginForm,HttpServletResponse response) {
		 UserItem item = userService.verifyLogin(loginForm.getUsername(), loginForm.getPassword());
		if(item!=null){
			SessionUtil.setAccessToken(response, item.getUserKey());
			if(item.getAdmin().equals("y")){
				return "admin";
			}else{
				return "admin";/// need to change to normal user page				
			}
		}else{
			return "login";
		}
		
	}
	 @RequestMapping("/logout")
	public String logOutUser(Model model, HttpServletRequest request, HttpServletResponse response){
		SessionUtil.removeAccesToken(request, response);
		model.addAttribute("logInForm", new LogInForm());
		return "login";
		
	}
}
