package testRabbitMq;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * ����Ϣ���С���������
 * @author Administrator
 *
 */
public class QueueSender {
	/**
	 * ��������
	 */
	private static final Logger logger = LoggerFactory.getLogger(QueueSender.class);
//	private String QUEUE = "batchinfovt";
//	private String exchange = "exchange_batchinfovt";
	private Connection con = null;
	private Channel channel = null;
	public QueueSender() {

		try {
			// ��ȡ����
			this.con = ConnectionUtils.getConnection();
			// �������д���ͨ��
			this.channel = con.createChannel();
			// ����һ������

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void closeConn() {
		ConnectionUtils.close(this.channel, this.con);
	}
	
	public void SendMsgQueue(String queue,String msg) {
		try {
			this.channel.queueDeclare(queue, true, false, false, null);
			logger.info("���÷��Ͷ���"+queue);

// ������Ϣ
			this.channel.basicPublish("", queue, null, msg.getBytes());
			logger.info("msg:"+msg);

			logger.info("send queue success info");
		} catch (IOException e) {
			e.printStackTrace();
		}  


	}
	public void SendMsgExchange(String exchange,String msg) {
		try {
         // ����exchange
	        this.channel.exchangeDeclare(exchange, "direct");
			logger.info("���÷��ͽ���"+exchange);

	     // ������Ϣ
	        this.channel.basicPublish("exchange_batchinfovt", "aa", null, msg.getBytes());
			logger.info("msg:"+msg);

			logger.info("send exchange success info");
		} catch (IOException e) {
			e.printStackTrace();
		}  


	}
 
}
