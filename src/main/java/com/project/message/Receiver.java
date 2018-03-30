package com.project.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// 监听“hello”队列
@RabbitListener(queues = "hello")
public class Receiver {

	@RabbitHandler
	// handler注解来指定对消息的处理方法
	public void process(String hello) {
		System.out.println("Receiver:" + hello);
	}
}
