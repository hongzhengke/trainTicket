package trainTicket.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import trainTicket.po.TrainInfo;
import trainTicket.service.TicketService;
import trainTicket.service.TrainService;

public class TrainServiceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/application-dao.xml"
				,"classpath:config/spring/application-service.xml");
		TrainService trainService = ctx.getBean(TrainService.class);
		TicketService ticketService = ctx.getBean(TicketService.class);
		
		TrainInfo trainInfo = new TrainInfo();
		trainInfo.setCode("G666");
		trainInfo.setDeparturePlace("广州");
		trainInfo.setDepartureTime(new Date(0,0,0,12,0,0));
		trainInfo.setDestinationPlace("潮汕");
		trainInfo.setDuration(10800);
		trainInfo.setSeatAmount(50);
		trainInfo.setCarriageAmount(3);
		trainService.addTrainInfo(trainInfo);
		/*ticketService.autoInsertTicketForAllTrain();
		trainService.deleteTrainInfo(19);*/
	}
}
