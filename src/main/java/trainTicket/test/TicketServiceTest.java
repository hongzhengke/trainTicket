package trainTicket.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import trainTicket.po.TicketCustom;
import trainTicket.po.TicketInfo;
import trainTicket.po.TrainInfo;
import trainTicket.service.TicketService;

public class TicketServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/application-dao.xml"
				,"classpath:config/spring/application-service.xml");
		TicketService ticketService = ctx.getBean(TicketService.class);
		
		TrainInfo traininfo = new TrainInfo();
		traininfo.setDeparturePlace("广州");
		traininfo.setDestinationPlace("潮汕");
		traininfo.setDepartureTime(new Date(0, 0, 0, 12, 0, 0));
		
		TicketInfo ticketInfo = new TicketInfo();
		ticketInfo.setDepartureDate(new Date(2018-1900, 6-1, 1));
		
		TicketCustom ticketCustom = new TicketCustom();
		ticketCustom.setTrainInfo(traininfo);
		ticketCustom.setTicketInfo(ticketInfo);
		
		List<TicketCustom>list = ticketService.queryTicket(ticketCustom);
		System.out.println("debug");
	}

}
