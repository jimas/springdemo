package net.hubs1.com.rabbitMQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/provide-rabbit.xml","classpath:spring/applicationContext-init.xml"})
public class RabbitMQMain {
	@Autowired
	private  RabbitTemplate rabbitTemplate;
	
	@Test
	public void testProducer() {
		
//		ArrayList<String> list=new ArrayList<String>();
		
		for (int i=0;i<100;i++) {
			rabbitTemplate.convertAndSend("demo"+i);
			
		}
	}
}
