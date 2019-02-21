package com.demo.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitTestRunner implements CommandLineRunner {

	@Autowired
	RabbitTemplate rt;
	
	@Override
	public void run(String... args) throws Exception {

		rt.convertAndSend("TestQueue","Hi there..!"); // TestQueue create from Rabbit admin console, can be created from code too.
		System.out.println("Message sent..");
		
		String msg = (String)rt.receiveAndConvert("TestQueue");
		System.out.println("Message received..:"+msg);
		// message will be null in case another listener subscribes to the queue
		
	}

}
