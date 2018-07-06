package com.pktech.service;

import com.pktech.entity.User;

public interface UserService {
	public User findUserByPhone(String phone);
	
	/**
	 * 实现用户注册
	 * @param user
	 */
	void register(User user);
}
