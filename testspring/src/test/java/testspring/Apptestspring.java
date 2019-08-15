package testspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//����spring-test
@RunWith(SpringJUnit4ClassRunner.class)
//ͨ������������spring�Զ�����
@ContextConfiguration(classes = Appconfig.class)
public class Apptestspring {
	
//�Զ�װ��
	@Autowired
	private MessagePrinter printer;
	@Test
	public void testPlay() {
		printer.printMessage();
	}
	

}
