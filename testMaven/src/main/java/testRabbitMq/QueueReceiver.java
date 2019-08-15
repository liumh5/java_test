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
 * �򵥶��С���������
 * 
 * @author Administrator
 *
 */
public class QueueReceiver {
	/**
	 * �������ƣ��������ߵĶ������Ʊ��뱣��һ��
	 */
//	private static final String QUEUE = "batchinfovt";
	private static final Logger logger = LoggerFactory.getLogger(QueueReceiver.class);
    private String msg = "";
    private Connection con = null;
    private Channel channel = null;
    public QueueReceiver() {
		
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
    
    public void ReceiverQueue(String Queue)  throws IOException, TimeoutException{

		try {
	    	// ��������
			this.channel.queueDeclare(Queue, true, false, false, null);
			// ����������
			Consumer consumer = new DefaultConsumer(this.channel) {
	                        // ��ȡ��Ϣ
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
						throws IOException {
				    String msg = new String(body, "utf-8");
				    setMsg(msg);
					logger.info("���յ���Ϣ����" + msg);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
	 
			};
			
			// ��������
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
