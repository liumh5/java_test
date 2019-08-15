package testspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@ComponentScan  
//ͨ��Appconfig.class��������
public class Application_spring {

	private static final Logger logger = LoggerFactory.getLogger(Application_spring.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Application_spring");
//ͨ��������,�����������  ��Ҫ @component  @componentscan  ���
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		
		
        MessagePrinter printer = context.getBean(MessagePrinter.class);        
        printer.printMessage();

	}

}
