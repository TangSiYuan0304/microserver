package com.pktech.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pktech.entity.User;
import com.pktech.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public Map<String,Object> login(@RequestParam String phone,@RequestParam String password){
		Map<String, Object> map=new HashMap<String,Object>();
		User user=new User();
			user=userService.findUserByPhone(phone);
			System.out.println(user.getPassword()+"----"+password);
			if(password.equals(user.getPassword())) {
				map.put("code","0000");
				map.put("msg", "登陆成功");
			}else {
				map.put("code", "0001");
				map.put("msg", "密码错误");
			}
			return map;
	}
	
	@CrossOrigin
	@RequestMapping(value="/register",method=RequestMethod.POST)	
	public Map<String, Object> register(
			@RequestParam String phone,@RequestParam String password,	
			@RequestParam String username,@RequestParam String name){
		Map<String, Object> map=new HashMap<String,Object>();
		
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		userService.register(user);
		map.put("code","0000");
		map.put("msg", "注册成功");
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getPhone());
		System.out.println(user.getUsername());
		return  map;
	}
}
