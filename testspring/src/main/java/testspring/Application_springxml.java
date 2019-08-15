package testspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application_springxml {
	private static final Logger logger = LoggerFactory.getLogger(Application_springxml.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.info("Application_springxml");
		//���������ļ�,�����������
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
		
	}

}
