package trainTicket.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;

import trainTicket.mapper.OrderCustomMapper;
import trainTicket.po.OrderCustom;
import trainTicket.po.UserCustom;

public class OrderCustomMapperTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/application-dao.xml");
		OrderCustomMapper orderCustomMapper = ctx.getBean(OrderCustomMapper.class);
		UserCustom userCustom = new UserCustom();
		userCustom.setUserId(1);
		userCustom.setCurrentDate(new Date());
		userCustom.setCurrentTime(new Date());
		OrderCustom orderCustom = orderCustomMapper.selectOrderByUserIdAndTime(userCustom).get(0);
		System.out.println("debug");

	}
}
