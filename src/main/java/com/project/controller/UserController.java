package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.User;
import com.project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @描述：添加用户
	 */
	@RequestMapping("/findUser")
	@ResponseBody
	public User findUser() {
		User user = this.userService.findUser("李四");
		return user;
	}

	/**
	 * 
	 * @描述：添加用户
	 */
	@RequestMapping("/findPageUser")
	@ResponseBody
	public List<User> findUser(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", required = false, defaultValue ="5") int pageSize) {
//		System.out.println("pageSize:"+pageSize);
		List<User> user = this.userService.findPageUser(pageNum, pageSize);
		return user;
	}
}