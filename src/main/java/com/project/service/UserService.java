package com.project.service;

import java.util.List;

import com.project.model.User;

public interface UserService {
	/**
	 * 
	 * @描述：根据名称查找用户信息
	 */
	User findUser(String string);

	/**
	 * 
	 * @描述：分页获取用户数据
	 */
	List<User> findPageUser(Integer pageNum, Integer pageSize);

}
