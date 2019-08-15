package testRabbitMq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiverMain {
	private static final Logger logger = LoggerFactory.getLogger(ReceiverMain.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String queue = "batchinfovt";
			QueueReceiver queuereceiver1 = new QueueReceiver();
			queuereceiver1.ReceiverQueue(queue);
			String msg = queuereceiver1.getMsg();
			logger.info(msg);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} 
	}

}
