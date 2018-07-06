package com.pktech.dao;

import org.apache.ibatis.annotations.Mapper;

import com.pktech.entity.User;

@Mapper
public interface UserDao {
	
	public User findUserByPhone(String phone);
	/**
	 * 插入数据
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 通过用户名查询User信息
	 * @param userName
	 * @return 如果没有此用户,返回null;
	 *             否则,返回该用户对象
	 */
	User selectUserByUserName(String userName);
	
}
