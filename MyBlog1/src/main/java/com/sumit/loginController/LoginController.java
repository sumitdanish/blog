package com.sumit.loginController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public void logout(HttpServletRequest request,HttpServletResponse response){
		System.out.println("calling logout");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			SecurityContextLogoutHandler logo = new SecurityContextLogoutHandler();
			logo.setClearAuthentication(true);
			logo.setInvalidateHttpSession(true);
			logo.logout(request, response, auth);
		}
	}
}
