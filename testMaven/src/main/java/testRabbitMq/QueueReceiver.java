package testRabbitMq;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
 
/**
 * 简单队列——消费者
 * 
 * @author Administrator
 *
 */
public class QueueReceiver {
	/**
	 * 队列名称，和生产者的队列名称必须保持一致
	 */
//	private static final String QUEUE = "batchinfovt";
	private static final Logger logger = LoggerFactory.getLogger(QueueReceiver.class);
    private String msg = "";
    private Connection con = null;
    private Channel channel = null;
    public QueueReceiver() {
		
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
    
    public void ReceiverQueue(String Queue)  throws IOException, TimeoutException{

		try {
	    	// 声明队列
			this.channel.queueDeclare(Queue, true, false, false, null);
			// 创建消费者
			Consumer consumer = new DefaultConsumer(this.channel) {
	                        // 获取消息
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
						throws IOException {
				    String msg = new String(body, "utf-8");
				    setMsg(msg);
					logger.info("接收到消息——" + msg);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
	 
			};
			
			// 监听队列
			channel.basicConsume(Queue, true, consumer);
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
    public void setMsg(String msg) {
    	this.msg = msg;
    }
    public String getMsg() {
    	return this.msg;
    }

}
