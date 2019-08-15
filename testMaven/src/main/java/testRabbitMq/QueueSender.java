package testRabbitMq;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 简单消息队列——生产者
 * @author Administrator
 *
 */
public class QueueSender {
	/**
	 * 队列名称
	 */
	private static final Logger logger = LoggerFactory.getLogger(QueueSender.class);
//	private String QUEUE = "batchinfovt";
//	private String exchange = "exchange_batchinfovt";
	private Connection con = null;
	private Channel channel = null;
	public QueueSender() {

		try {
			// 获取连接
			this.con = ConnectionUtils.getConnection();
			// 从连接中创建通道
			this.channel = con.createChannel();
			// 声明一个队列

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
			logger.info("设置发送队列"+queue);

// 发送消息
			this.channel.basicPublish("", queue, null, msg.getBytes());
			logger.info("msg:"+msg);

			logger.info("send queue success info");
		} catch (IOException e) {
			e.printStackTrace();
		}  


	}
	public void SendMsgExchange(String exchange,String msg) {
		try {
         // 设置exchange
	        this.channel.exchangeDeclare(exchange, "direct");
			logger.info("设置发送交换"+exchange);

	     // 发送消息
	        this.channel.basicPublish("exchange_batchinfovt", "aa", null, msg.getBytes());
			logger.info("msg:"+msg);

			logger.info("send exchange success info");
		} catch (IOException e) {
			e.printStackTrace();
		}  


	}
 
}
