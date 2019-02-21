package com.demo.spring;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues="TestQueue")
@Component
public class MyRabbitListener {

	
	public MyRabbitListener() {
		
		System.out.println("Listening...");
	}
	
	@RabbitHandler
	public void receive(String msg) {
		
		System.out.println("Received new msg..: "+msg);
	}
}
