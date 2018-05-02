package trainTicket.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import trainTicket.po.OrderCustom;
import trainTicket.po.TicketCustom;
import trainTicket.po.TicketInfo;
import trainTicket.po.TrainInfo;
import trainTicket.po.User;
import trainTicket.service.OrderService;
import trainTicket.service.TicketService;

public class OrderServiceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/application-dao.xml"
				,"classpath:config/spring/application-service.xml");
		OrderService orderService = ctx.getBean(OrderService.class);
		TicketService ticketService = ctx.getBean(TicketService.class);
		
		TrainInfo traininfo = new TrainInfo();
		traininfo.setDeparturePlace("广州");
		traininfo.setDestinationPlace("潮汕");
		traininfo.setDepartureTime(new Date(0, 0, 0, 12, 0, 0));
		
		TicketInfo ticketInfo = new TicketInfo();
		ticketInfo.setDepartureDate(new Date(2018-1900, 5-1, 2));
		
		TicketCustom ticketCustom = new TicketCustom();
		ticketCustom.setTrainInfo(traininfo);
		ticketCustom.setTicketInfo(ticketInfo);
		
		List<TicketCustom>list = ticketService.queryTicket(ticketCustom);
		
		
		User user = new User();
		user.setId(3);
		orderService.buyTicket(user, list.get(0));
		/*OrderCustom orderCustom = orderService.selectCurrentOrderByUserId(3).get(0);
		orderService.refundTicket(orderCustom);*/
	}

}
