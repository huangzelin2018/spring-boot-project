package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.mapper.UserMapper;
import com.project.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUser(String name) {
		return this.userMapper.findUser(name);
	}

	@Override
	@Transactional
	public List<User> findPageUser(Integer pageNum, Integer pageSize) {
		User user = new User();
		user.setId(1L);
		user.setAge(85);
		int num = this.userMapper.update(user);
		User u = new User();
		u.setId(2L);
		u.setAge(30);
		int num1 = this.userMapper.update(u);
		
//		int a=1/0;
		
		User uu = new User();
		uu.setId(2L);
		uu.setAge(37);
		int num2 = this.userMapper.update(uu);
		System.out.print(pageSize);
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = this.userMapper.findAllUser();
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		return pageInfo.getList();
	}

}
