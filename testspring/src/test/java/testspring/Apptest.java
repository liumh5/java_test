package testspring;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Apptest {

	//��Ԫ������
@Test
public void testplay() {
	//����������,�����������
	ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
    MessagePrinter printer = context.getBean(MessagePrinter.class);    
    printer.printMessage();
}

}
