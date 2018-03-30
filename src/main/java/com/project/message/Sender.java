package com.project.message;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
   @Autowired
   private AmqpTemplate rabbitMQTemplate;
 
   public void send() {
      String context = "hello :" + new Date();
      System.out.println("Sender : " + context);
      this.rabbitMQTemplate.convertAndSend("hello",context);
   }
}
