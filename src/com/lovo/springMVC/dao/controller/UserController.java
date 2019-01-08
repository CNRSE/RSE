package com.lovo.springMVC.dao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	//不写value不管post、get请求都可以接收
	@RequestMapping(value="registController",method=RequestMethod.POST)
	public String getUser(@RequestParam("username")String username,
			@RequestParam("password")String password) {
		
		return null;
	}
}
