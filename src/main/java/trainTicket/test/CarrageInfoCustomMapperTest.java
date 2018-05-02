package trainTicket.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import trainTicket.mapper.CarrageInfoCustomMapper;
import trainTicket.po.CarrageInfo;

public class CarrageInfoCustomMapperTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/application-dao.xml"
				,"classpath:config/spring/application-service.xml");
		CarrageInfoCustomMapper carrageInfoCustomMapper = ctx.getBean(CarrageInfoCustomMapper.class);
		
		CarrageInfo carrageInfo1 = new CarrageInfo();
		carrageInfo1.setCarriageNumber(1);
		carrageInfo1.setSeatAmount(50);
		carrageInfo1.setTicketInfoId(666);
		
		CarrageInfo carrageInfo2 = new CarrageInfo();
		carrageInfo2.setCarriageNumber(1);
		carrageInfo2.setSeatAmount(50);
		carrageInfo2.setTicketInfoId(667);
		
		List<CarrageInfo>carrageInfos = new ArrayList<>();
		carrageInfos.add(carrageInfo1);
		carrageInfos.add(carrageInfo2);
		
		carrageInfoCustomMapper.insertBatch(carrageInfos);
		System.out.println(carrageInfo1.getId());
		System.out.println(carrageInfo2.getId());
	}
}
