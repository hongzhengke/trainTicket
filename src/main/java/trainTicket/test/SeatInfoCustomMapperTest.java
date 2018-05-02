package trainTicket.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import trainTicket.mapper.SeatInfoCustomMapper;
import trainTicket.po.SeatInfo;

public class SeatInfoCustomMapperTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/application-dao.xml"
				,"classpath:config/spring/application-service.xml");
		SeatInfoCustomMapper seatInfoCustomMapper = ctx.getBean(SeatInfoCustomMapper.class);
		SeatInfo seatInfo = seatInfoCustomMapper.selectOneSeatByTicketId(162);
		System.out.println("debug");
	}
}
