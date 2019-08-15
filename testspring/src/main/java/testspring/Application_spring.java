package testspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@ComponentScan  
//通过Appconfig.class加载配置
public class Application_spring {

	private static final Logger logger = LoggerFactory.getLogger(Application_spring.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Application_spring");
//通过配置类,引入相关配置  需要 @component  @componentscan  配合
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		
		
        MessagePrinter printer = context.getBean(MessagePrinter.class);        
        printer.printMessage();

	}

}
