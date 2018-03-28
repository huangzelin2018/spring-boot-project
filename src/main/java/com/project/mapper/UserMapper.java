package com.project.mapper;

import java.util.List;

import com.project.model.User;

public interface UserMapper {
	public User findUser(String name);

	public List<User> findAllUser();

	/**
	 * @描述：更新用户信息
	 */
	public int update(User user);
}
