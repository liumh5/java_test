package testspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//��ʾ����spring,������Щ���ǽ���spring�������й���  @componentscan �Զ�����
@Component
public class MessageService {

	private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

	public MessageService() {
		logger.info("MessageService is start");
	}

	public String getMessage() {
		return "Hello World!";
	}
}
