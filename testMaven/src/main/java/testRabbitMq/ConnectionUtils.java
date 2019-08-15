package testRabbitMq;
 
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
/**
 * rabbitmq���ӹ�����
 * @author Administrator
 *
 */
public class ConnectionUtils {
	/**
	 * ��ȡ����
	 * @return
	 * @throws IOException
	 * @throws TimeoutException
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConnectionUtils.class);

	public static Connection getConnection() throws IOException, TimeoutException{
		ConnectionFactory factory = new ConnectionFactory();
		String ip = "192.168.31.74";
		int port = 5672;
		String virtualhost = "vhost_test";
		String username = "admin";
		String password = "admin";
		// ���÷����ַ
		factory.setHost(ip);
		// �˿�
		factory.setPort(port);
		// vhost
		factory.setVirtualHost(virtualhost);
		// �û���
		factory.setUsername(username);
		// ����
		factory.setPassword(password);
		logger.info("������:"+ip+":"+port+":"+virtualhost+":"+username+":"+password);

		return factory.newConnection();
	}
	/**
	 * �ر�����
	 * @param channel
	 * @param con
	 */
	public static void close(Channel channel,Connection con){
		if(channel != null){
			try {
				channel.close();
				logger.info("�ر�����");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
 
}