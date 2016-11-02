package net.hubs1.com.rabbitMQ;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RabbitmqConsumerTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:spring/consumer-rabbitmq.xml","classpath:spring/applicationContext-init.xml");
	}
	
}
