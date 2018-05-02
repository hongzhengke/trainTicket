package trainTicket.test;

import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javassist.CtClass;
import trainTicket.mapper.TicketCustomMapper;
import trainTicket.mapper.TrainInfoMapper;
import trainTicket.mapper.UserMapper;
import trainTicket.po.*;

public class TicketCustomMapperTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/application-dao.xml");
		TicketCustomMapper ticketCustomMapper = ctx.getBean(TicketCustomMapper.class);
		/*TicketInfo ticketinfo = new TicketInfo();
		ticketinfo.setDepartureDate(new Date(2018-1900, 4 - 1, 29));
		
		ticketinfo = ticketCustomMapper.testSelect(ticketinfo);
		System.out.println(ticketinfo);*/
		
	    TrainInfo traininfo = new TrainInfo();
		traininfo.setDeparturePlace("广州");
		traininfo.setDestinationPlace("潮汕");
		traininfo.setDepartureTime(new Date(0, 0, 0, 12, 0, 0));
		
		TicketInfo ticketInfo = new TicketInfo();
		ticketInfo.setDepartureDate(new Date(2018-1900, 6-1, 1));
		
		TicketCustom ticketCustom = new TicketCustom();
		ticketCustom.setTrainInfo(traininfo);
		ticketCustom.setTicketInfo(ticketInfo);
		
		TicketCustom result = ticketCustomMapper.selectTicket(ticketCustom).get(0);
		System.out.println(result);
		System.out.println("wait");
	}

}
