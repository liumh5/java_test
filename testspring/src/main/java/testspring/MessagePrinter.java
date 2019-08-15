package testspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//��ʾ����spring,������Щ���ǽ���spring�������й���  @componentscan �Զ�����
@Component
public class MessagePrinter {

	private static final Logger logger = LoggerFactory.getLogger(MessagePrinter.class);

	private MessageService service ;
	public MessagePrinter() {
		logger.info("MessagePrinter is start");
	}
	
	public MessageService getService() {
		return service;
	}
//	
	/**
	 * @Autowired 
	 * @Autowired (required = false) S
	 * @Autowired
	 * private MessageService service ;
	 * 
	 * @Autowired
	 * public MessagePrinter(MessageService service) {
	 *    this.service = service
	 * }
	 * 	@Autowired
	 * public void setService(MessageService service) {
     *    this.service = service;
	 *  
	 *  }
	 * 
	 * */
	@Autowired
	public void setService(MessageService service) {
		this.service = service;
	}

	public void printMessage() {
		logger.info(this.service.getMessage());
	}
}
