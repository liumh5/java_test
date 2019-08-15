package testspring;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Apptest {

	//单元测试类
@Test
public void testplay() {
	//声明配置类,引入相关配置
	ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
    MessagePrinter printer = context.getBean(MessagePrinter.class);    
    printer.printMessage();
}

}
