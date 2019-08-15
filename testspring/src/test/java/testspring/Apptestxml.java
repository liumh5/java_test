package testspring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Apptestxml {

	@Test
	public void testplay() {
		//声明配置类,引入相关配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    MessagePrinter printer = context.getBean(MessagePrinter.class);    
	    printer.printMessage();
	}
}
