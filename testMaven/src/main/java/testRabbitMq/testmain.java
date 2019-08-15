package testRabbitMq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class testmain {
	private static final Logger logger = LoggerFactory.getLogger(testmain.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			QueueSender queuesender1 = new QueueSender();
			String queue = "batchinfovt";
			logger.info(queue);
			for (int i = 0 ;i < 5 ; i ++) {
				String msg = "test queue msg :" + String.valueOf(i);
				queuesender1.SendMsgQueue(queue, msg);
				
			}

			queuesender1.closeConn();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		

	}

}
