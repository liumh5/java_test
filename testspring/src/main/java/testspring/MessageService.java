package testspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//显示配置spring,表明这些类是交给spring容器进行管理  @componentscan 自动声明
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
