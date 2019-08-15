package testspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//引入spring-test
@RunWith(SpringJUnit4ClassRunner.class)
//通过配置类引入spring自动配置
@ContextConfiguration(classes = Appconfig.class)
public class Apptestspring {
	
//自动装配
	@Autowired
	private MessagePrinter printer;
	@Test
	public void testPlay() {
		printer.printMessage();
	}
	

}
