package testspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//引入spring-test
@RunWith(SpringJUnit4ClassRunner.class)
//通过xml文件引入spring自动配置
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Apptestsprintxml {
	//单元测试类
	
	@Autowired
	private MessagePrinter printer;
@Test
public void testplay() {
	//声明配置类,引入相关配置
    printer.printMessage();
}
}
