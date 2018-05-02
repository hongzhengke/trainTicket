package trainTicket.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import trainTicket.po.User;
import trainTicket.service.UserService;
import trainTicket.service.UserServiceImpl;

public class UserServiceImplTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/application-dao.xml"
				,"classpath:config/spring/application-service.xml");
		UserService userService = ctx.getBean(UserService.class);
		User user = userService.findUserByTelAndPassword("17620059106", "123456");
		System.out.println(user);
		
	}

}
