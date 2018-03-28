package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.User;
import com.project.utils.RedisUtils;

@Controller
public class RedisController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisUtils redisUtils;

	@RequestMapping("/setRedis")
	@ResponseBody
	public String setRedis() {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("token:aaa", "111");
		return "ok";
	}

	/**
	 * 添加数据到redis中
	 */
	@RequestMapping(value = "/addRedis", method = RequestMethod.GET)
	@ResponseBody
	public String addRedis() {
		System.out.println("================addRedis=================");
		this.redisUtils.hmSet("a", "test:aaa", "123456");
		User user = new User();
		user.setName("wyait");
		user.setAge(5);
		this.redisUtils.add("user:1", user);
		this.redisUtils.set("userSet:1", user);
		this.redisUtils.zsetAdd("userZset:1", user, 100);
		List<User> list = new ArrayList<User>();
		list.add(user);
		this.redisUtils.listPush("userList:1", list);
		return "ok";
	}

}
