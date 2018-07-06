package com.pktech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pktech.dao.UserDao;
import com.pktech.entity.User;
import com.pktech.service.UserService;
import com.pktech.service.impl.ex.UserNameAlreadyExistException;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;

	@Override
	public User findUserByPhone(String phone) {
		
		return userdao.findUserByPhone(phone);
	}

	@Override
	public void register(User user) {
		//1.调用selectUserByUserName(user.getUserName());返回User对象 user
		User user1 = 
				userdao.selectUserByUserName(user.getUsername());
	//2.判断user==null
		if(user1==null){
			//3.如果为空,调用insertUser(user)方法;	
			userdao.insertUser(user);
		}else{
			//4.如果不为空,抛出异常UserNameAlreadyExistException
			throw new UserNameAlreadyExistException("用户名已经存在!");
		}
		
	}

}
