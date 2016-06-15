package com.sumit.loginController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sumit.entity.User;

@RestController
public class LoginController {

	
	@RequestMapping(value="/user")
	public Principal user(Principal user){
		return user;
	}
	
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public Map<String, User> login(){
		User u = new User();
		u.setName("sumit");
		u.setPassword("sumit@123");
		Map<String,User> map = new HashMap<String,User>();
		map.put("user", u);
		return map;
	}
	@RequestMapping("/admin")
	public String admin(){
		return "admin";
	}
	@RequestMapping(value="/signIn", method = RequestMethod.GET)
	public ModelAndView signIn(){
		System.out.println("Calling SIngIn");
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
}
