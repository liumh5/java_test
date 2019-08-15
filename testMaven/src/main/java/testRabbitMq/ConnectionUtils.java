package testRabbitMq;
 
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
/**
 * rabbitmq连接工具类
 * @author Administrator
 *
 */
public class ConnectionUtils {
	/**
	 * 获取连接
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
		// 设置服务地址
		factory.setHost(ip);
		// 端口
		factory.setPort(port);
		// vhost
		factory.setVirtualHost(virtualhost);
		// 用户名
		factory.setUsername(username);
		// 密码
		factory.setPassword(password);
		logger.info("打开链接:"+ip+":"+port+":"+virtualhost+":"+username+":"+password);

		return factory.newConnection();
	}
	/**
	 * 关闭连接
	 * @param channel
	 * @param con
	 */
	public static void close(Channel channel,Connection con){
		if(channel != null){
			try {
				channel.close();
				logger.info("关闭链接");
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