package testspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application_main {
	private static final Logger logger = LoggerFactory.getLogger(Application_main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.info("Application_main");
		
		MessagePrinter printer = new MessagePrinter();
		MessageService service = new MessageService();
		
		printer.setService(service);
		printer.printMessage();
	}

}
