package testspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//����spring-test
@RunWith(SpringJUnit4ClassRunner.class)
//ͨ��xml�ļ�����spring�Զ�����
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Apptestsprintxml {
	//��Ԫ������
	
	@Autowired
	private MessagePrinter printer;
@Test
public void testplay() {
	//����������,�����������
    printer.printMessage();
}
}
