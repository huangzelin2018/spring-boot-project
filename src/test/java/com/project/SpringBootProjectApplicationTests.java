package com.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.message.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootProjectApplicationTests {

	@Autowired
	private Sender send;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() {
		System.out.println("==========发送消息！");
		send.send();
	}

}
