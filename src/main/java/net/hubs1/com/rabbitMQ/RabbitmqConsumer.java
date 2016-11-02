package net.hubs1.com.rabbitMQ;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("rabbitmqConsumer")
public class RabbitmqConsumer {
	
	private static final Logger logger = Logger.getLogger(RabbitmqConsumer.class);
	
	public void onMessage(String message) throws Exception {
		logger.info("mq  message: "+message);
	}

}
